package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kira on 07.10.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message nameRequestResponse = connection.receive();
                if (!nameRequestResponse.getType().equals(MessageType.USER_NAME))
                {
                    ConsoleHelper.writeMessage("Неверный ответ клиента (не USER_NAME)");
                    continue;
                }
                if ((nameRequestResponse.getData() == null) || (nameRequestResponse.getData().isEmpty()))
                {
                    ConsoleHelper.writeMessage("Отсутствует имя клиента");
                    continue;
                }
                String clientName = nameRequestResponse.getData();
                if (connectionMap.containsKey(clientName))
                {
                    ConsoleHelper.writeMessage("Пользователь с таким именем уже подключен");
                    continue;
                }
                connectionMap.put(clientName,connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return clientName;
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> pair: connectionMap.entrySet())
            {
                if (!pair.getKey().equals(userName))
                {
                    Message message = new Message(MessageType.USER_ADDED, pair.getKey());
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (!message.getType().equals(MessageType.TEXT))
                {
                    ConsoleHelper.writeMessage("Принятое сообщение не является текстом (TEXT)");
                    continue;
                }
                String textMessage = userName + ": " + message.getData();
                sendBroadcastMessage(new Message(MessageType.TEXT,textMessage));
            }
        }

        public void run()
        {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String clientName = null;

            try (Connection connection = new Connection(socket)){
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
            } catch (IOException e)
            {
                ConsoleHelper.writeMessage("Ошибка обмена данными с удаленным адресом");
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("Ошибка обмена данными с удаленным адресом");

            }
            if (clientName != null)
            {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом " + socket.getRemoteSocketAddress() + "закрыто");
        }

    }

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
            {
                pair.getValue().send(message);
            }
        } catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения");
        }
    }


    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен, порт: " + port);
            while (true)
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }

        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}
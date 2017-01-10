package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Kira on 11.10.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            try
            {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                switch (message.getType()) {
                    case NAME_REQUEST: {
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME,userName));
                        break;
                    }
                    case NAME_ACCEPTED: {
                        notifyConnectionStatusChanged(true);
                        return;
                    }
                    default: {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (!Thread.currentThread().isInterrupted())
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case TEXT:
                    {
                        processIncomingMessage(message.getData());
                        break;
                    }
                    case USER_ADDED:
                    {
                        informAboutAddingNewUser(message.getData());
                        break;
                    }
                    case USER_REMOVED:
                    {
                        informAboutDeletingNewUser(message.getData());
                        break;
                    }
                    default:
                    {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Input server address");
        return ConsoleHelper.readString();
    }
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Input server port");
        return ConsoleHelper.readInt();
    }
    protected String getUserName() {
        ConsoleHelper.writeMessage("Input user name");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSentTextFromConsole() {
        return true;
    }
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("error send message");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                ConsoleHelper.writeMessage("client work interrupted");
                return;
            }
        }
        if (clientConnected)
            ConsoleHelper.writeMessage("Connection established. For exit write \"exit\"");
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }

        while (true)
        {
            String text = ConsoleHelper.readString();
            if (text.equalsIgnoreCase("exit"))
                break;
            if (shouldSentTextFromConsole())
                sendTextMessage(text);
        }


    }

    public static void main(String[] args)
    {
        new Client().run();
    }
}

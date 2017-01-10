package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject))
            {
                System.out.println("равны");
            } else
            {
                System.out.println("не равны");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            int userSize = users.size();
            writer.println(userSize);
            for (int i = 0; i < userSize; i++)
            {
                writer.println(users.get(i).getFirstName());
                writer.println(users.get(i).getLastName());
                writer.println(users.get(i).getBirthDate().getTime());
                writer.println(users.get(i).isMale());
                writer.println(users.get(i).getCountry().getDisplayedName());
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            for (int i = 0; i < size; i++)
            {
                User user = new User();
                String firstName = reader.readLine();
                user.setFirstName(firstName);
                String lastName = reader.readLine();
                user.setLastName(lastName);
                String birthDate = reader.readLine();
                    Date date = new Date();
                    date.setTime(Long.parseLong(birthDate));
                    user.setBirthDate(date);
                String isMale = reader.readLine();
                    user.setMale(Boolean.parseBoolean(isMale));
                String country = reader.readLine();

                    if (country.equals("Ukraine"))
                        user.setCountry(User.Country.UKRAINE);
                    else if (country.equals("Russia"))
                        user.setCountry(User.Country.RUSSIA);
                    else
                        user.setCountry(User.Country.OTHER);

                users.add(user);


            }
            reader.close();

        }
    }
}

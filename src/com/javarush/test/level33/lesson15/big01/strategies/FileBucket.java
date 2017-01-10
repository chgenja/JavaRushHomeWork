package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Kira on 03.01.2017.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp",null);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(entry);
            objectOutputStream.close();
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            ExceptionHandler.log(e);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (path.toFile().length()==0)
            return null;
        Entry result = null;
        try {
            FileInputStream inputStream = new FileInputStream(path.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            result = (Entry) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        }
        catch (FileNotFoundException e) {
            ExceptionHandler.log(e);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        return result;
    }

    public void remove() {
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}

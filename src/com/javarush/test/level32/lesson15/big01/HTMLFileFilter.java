package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.nio.file.Files;

/**
 * Created by Kira on 02.12.2016.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        else {
            String s = f.getName().toLowerCase();
            return s.endsWith(".html") || s.endsWith(".htm");
        }
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}

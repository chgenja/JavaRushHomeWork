package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Kira on 29.11.2016.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader,document,0);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer,document,0,document.getLength());
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int n = jFileChooser.showOpenDialog(view);
        if (n == jFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader reader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(reader,document,0);
                view.resetUndo();
            }
            catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            }
            catch (IOException e) {
                ExceptionHandler.log(e);
            }
            catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument() {
        if (currentFile == null) {
            saveDocumentAs();
            return;
        }
        view.selectHtmlTab();
        try {
            FileWriter writer = new FileWriter(currentFile);
            new HTMLEditorKit().write(writer,document,0,document.getLength());
            writer.close();
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }


    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int n = jFileChooser.showSaveDialog(view);
        if (n == jFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer,document,0,document.getLength());
                writer.close();
            }
            catch (IOException e) {
                ExceptionHandler.log(e);
            }
            catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}

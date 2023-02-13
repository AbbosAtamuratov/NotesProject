package org.example;

import org.example.Database.*;
import org.example.FileManager.TXTFileManager;
import org.example.View.Display;

public class Main {
    public static void main(String[] args) {
        Display d = new Display();
        DataBase DB = new DataBase(d);
        TXTFileManager fm = new TXTFileManager("notes.txt");
        DB.setNotepad(fm.load());
        DB.showAll();
    }
}
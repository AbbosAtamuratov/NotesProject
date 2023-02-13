package org.example;

import org.example.Controller.CentralController;
import org.example.Database.*;
import org.example.FileManager.TXTFileManager;
import org.example.View.Display;

public class Main {
    public static void main(String[] args) {
        Display d = new Display();
        DataBase DB = new DataBase(d);
        CentralController bigRedButton = new CentralController(DB);
        bigRedButton.run();
    }
}
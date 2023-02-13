package org.example;

import org.example.Database.*;
import org.example.View.Display;

public class Main {
    public static void main(String[] args) {
        Display d = new Display();
        DataBase DB = new DataBase(d);
        DB.create();
        String s = DB.validateId("4");
        System.out.println(s);
    }
}
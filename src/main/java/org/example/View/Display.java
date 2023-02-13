package org.example.View;

import org.example.Controller.Command;
import org.example.Note.Note;

import java.util.List;
import java.util.Scanner;

public class Display {

    public String promt(String msg){
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void flash(String msg){ System.out.println(msg); }
    public void greet() {
        System.out.println("Halo!");
    }

    public void okBye() { System.out.println("Всего хорошего..."); }

    public void wtf() { System.out.println("Что-то явно пошло не так..."); }

    public void showAll(List<Note> notes){ for(Note n : notes) System.out.println(n); }

    public void littleHelper(){
        int i = 1;
        for (Command c: Command.values()) {
            if (c != Command.NONE) {
                System.out.printf("%d. %s\n", i, c.toString());
                i++;
            }
        }
    }

    public int pickFileManager(){
        System.out.println("В каком формате будет сохранять наши записки?");
        System.out.println("" +
                "1. txt" +
                "2. xml" +
                "3. json");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        if (input.contains("txt") || input.contains("1"))
            return 1;
        else if (input.contains("xml") || input.contains("2"))
            return 2;
        else if (input.contains("json") || input.contains("3"))
            return 3;
        else throw new RuntimeException();
    }
}

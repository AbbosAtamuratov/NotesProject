package org.example.View;

import org.example.Controller.Command;
import org.example.Note.Note;

import java.util.HashMap;
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

    public void showAll(List<Note> notes){ notes.forEach(n -> System.out.println(n)); }

    public void littleHelper(){
        int i = 1;
        for (Command c: Command.values()) {
            if (c != Command.NONE) {
                System.out.printf("%d. %s\n", i, c.toString());
                i++;
            }
        }
    }
}

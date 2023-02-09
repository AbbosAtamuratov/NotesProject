package org.example.View;

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

    public void wtf() { System.out.println("Команда не распознана..."); }
}

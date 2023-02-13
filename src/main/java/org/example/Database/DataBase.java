package org.example.Database;

import org.example.Note.*;
import org.example.View.Display;

import java.util.*;

public class DataBase implements Based{
    private Display display;
    private List<Note> notepad = new ArrayList<>();

    public DataBase(Display display) { this.display = display; }

    public Display getDisplay() { return display; }


    @Override
    public void save() {

    }

    @Override
    public void create() {
        String head = display.promt("Введите заголовок: ");
        String text = display.promt("Введите текст: ");

        notepad.add(new Note(head, text));
        System.out.println("Запись успешно создана...");
    }

    @Override
    public void edit(String id) {
        String userInputHead = display.promt("Введите новый заголовок: ");
        String userInputText = display.promt("Введите новый текст: ");
        notepad.get(Integer.parseInt(id)).setTitle(userInputHead);
        notepad.get(Integer.parseInt(id)).setTitle(userInputText);
        System.out.printf("Запись %s успешно отредактирована...\n", id);
    }

    @Override
    public void find(String id) {
        display.flash(notepad.get(Integer.parseInt(id)).toString());
    }

    @Override
    public void remove(String id) {
        notepad.remove(Integer.parseInt(id));
        System.out.printf("Запись %s успешно удалена...\n", id);
    }

    @Override
    public void showAll() {
        display.showAll(notepad);
    }

    @Override
    public void menu() {
        display.littleHelper();
    }

    public String validateId(String id){
        try {
            int num = Integer.parseInt(id);
            List<Integer> ids = new ArrayList<>();
            for (Note n : notepad)
                ids.add(n.getId());
            if (ids.contains(num))
                return id;
            else
                return "Указанного id не найдено";
        } catch (NumberFormatException e) { return "Некорректный ввод"; }
    }
}

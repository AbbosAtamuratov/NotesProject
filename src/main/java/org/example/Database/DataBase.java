package org.example.Database;

import org.example.Note.*;
import org.example.View.Display;
import java.util.HashMap;

public class DataBase implements Based{
    private Display display;
    private HashMap<Integer, Note> notepad = new HashMap<>();
    private static int id = 1;

    public DataBase(Display display) { this.display = display; }

    public Display getDisplay() { return display; }

    public static void setId(int id) { DataBase.id = id; }

    @Override
    public void save() {

    }

    @Override
    public void create() {
        String head = display.promt("Введите заголовок: ");
        String text = display.promt("Введите текст: ");

        notepad.put(id, new Note(head, text));
        id++;
        System.out.println("Запись успешно создана...");
    }

    @Override
    public void edit(String id) {
        String userInputHead = display.promt("Введите новый заголовок: ");
        String userInputText = display.promt("Введите новый текст: ");
        notepad.replace(Integer.parseInt(id), new Note(userInputHead, userInputText));
        System.out.println("Запись успешно отредактирована...");
    }

    @Override
    public void find(String id) {
        display.flash(notepad.get(Integer.parseInt(id)).toString());
    }

    @Override
    public void remove(String id) {
        notepad.remove(Integer.parseInt(id));
        System.out.println("Запись успешно удалена...");
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
            if (notepad.containsKey(num))
                return id;
            else
                return "Указанного ключа не найдено";
        } catch (NumberFormatException e) { return "Некорректный ввод"; }
    }
}

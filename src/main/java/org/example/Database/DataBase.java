package org.example.Database;

import org.example.Note.*;
import org.example.View.Display;

import java.util.*;

public class DataBase implements Based {
    private Display display;
    private List<Note> notepad = new ArrayList<Note>();

    public DataBase(Display display) {
        this.display = display;
    }

    public Display getDisplay() {
        return display;
    }

    public void setNotepad(List<Note> notepad) {
        this.notepad = notepad;
    }

    public List<Note> getNotepad() {
        return notepad;
    }

    public void create() {
        String head = display.promt("Введите заголовок: ");
        String text = display.promt("Введите текст: ");
        int id = 0;
        if (notepad.isEmpty())
            id =1;
        else
            id = getMaxId()+1;
        notepad.add(new Note(head, text, id));
        System.out.println("Запись успешно создана...");
    }

    private int getMaxId() {
        int maxId = 1;
        for (Note note : notepad) {
            int id = note.getId();
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId;
    }

    public void edit(String id) {
        String userInputHead = display.promt("Введите новый заголовок: ");
        String userInputText = display.promt("Введите новый текст: ");
        notepad.get(Integer.parseInt(id)).setTitle(userInputHead);
        notepad.get(Integer.parseInt(id)).setTitle(userInputText);
        System.out.printf("Запись %s успешно отредактирована...\n", id);
    }

    public void find(String id) {
        display.flash(notepad.get(Integer.parseInt(id)).toString());
    }

    public void remove(String id) {
        notepad.remove(Integer.parseInt(id));
        System.out.printf("Запись %s успешно удалена...\n", id);
    }

    public void showAll() {
        display.showAll(notepad);
    }

    public void menu() {
        display.littleHelper();
    }

    public String validateId(String id) {
        try {
            int num = Integer.parseInt(id);
            List<Integer> ids = new ArrayList<Integer>();
            for (Note n : notepad)
                ids.add(n.getId());
            if (ids.contains(num))
                return id;
            else
                return "Указанного id не найдено";
        } catch (NumberFormatException e) {
            return "Некорректный ввод";
        }
    }
}
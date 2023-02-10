package org.example.FileManager;

import org.example.Note.Note;

import java.util.HashMap;

public interface Managable {
    void save(HashMap<Integer, Note> notes);
    HashMap<Integer, Note> load();
}

package org.example.FileManager;

import org.example.Note.Note;

import java.util.List;

public interface Managable {
    void save(List<Note> notes);
    List<Note> load();
}

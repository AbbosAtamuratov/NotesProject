package org.example.FileManager;

import org.example.Note.Note;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TXTFileManager implements Managable {
    private String filename;

    public TXTFileManager(String filename) {
        this.filename = filename;
    }

    public void save(List<Note> notes) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            for(Note n : notes){
                StringBuilder sb = new StringBuilder();
                sb.append("id: ").append(n.getId()).append(";");
                sb.append(" title: ").append(n.getTitle()).append(";");
                sb.append(" text: ").append(n.getText()).append("\n");
                try {
                    fw.write(sb.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> load() {
        List<Note> loadedNotes = new ArrayList<Note>();
        List<String> allNotes = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            if (line != null)
                allNotes.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null)
                    allNotes.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String sn : allNotes) loadedNotes.add(parseNote(sn));
        return loadedNotes;
    }

    private Note parseNote(String stringNote) {

        String[] parts = stringNote.split(";", 3);

        int id = Integer.parseInt(parts[0].substring(4).trim());
        String title = parts[1].substring(7).trim();
        String text = parts[2].substring(7).trim();

        Note ldNote = new Note(title, text, id);
        return ldNote;
    }
}

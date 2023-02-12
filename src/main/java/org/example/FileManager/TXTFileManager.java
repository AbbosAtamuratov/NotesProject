package org.example.FileManager;

import org.example.Note.Note;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TXTFileManager implements Managable {
    private String filename;

    public TXTFileManager(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(HashMap<Integer, Note> notes) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            notes.forEach((k, v) -> {
                StringBuilder sb = new StringBuilder();
                sb.append("id: ").append(k).append(";");
                sb.append(" title: ").append(v.getTitle()).append(";");
                sb.append(" text: ").append(v.getText()).append("\n");
                try {
                    fw.write(sb.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HashMap<Integer, Note> load() {
        HashMap<Integer, Note> loadedNotes = new HashMap<>();
        List<String> allNotes = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            if (line != null)
                allNotes.add(line);
            while (line != null){
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

        return loadedNotes;
    }

    private String[] slpitter(String stringNote){
        String[] res = stringNote.split(";");
        if (res.length > 3) {
            for (int i = 3; i < res.length; i++) {
                res[2] += String.format("; %s", res[i]);
                res[i] = null;
            }

        }
        return res;
    }
}

package org.example.FileManager;

import org.example.Note.Note;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TXTFlieManager implements Managable {
    private String filename;

    public TXTFlieManager(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(HashMap<Integer, Note> notes) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            notes.forEach((k, v) -> {
                StringBuilder sb = new StringBuilder();
                sb.append("id: ").append(k);
                sb.append(" title: ").append(v.getTitle());
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


        return null;
    }
}

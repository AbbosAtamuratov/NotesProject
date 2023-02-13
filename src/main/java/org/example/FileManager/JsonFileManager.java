package org.example.FileManager;

import org.example.Note.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileManager implements Managable{

    private String fileName;

    public JsonFileManager(String fileName) {
        this.fileName = fileName;
    }

    public void save(List<Note> notes) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(fileName), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Note> load() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, Note.class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

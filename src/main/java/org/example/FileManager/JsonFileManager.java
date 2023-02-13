package org.example.FileManager;

import org.example.Note.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileManager extends FileManager implements Managable {

    public JsonFileManager(String fileName) {
        super(fileName);
    }

    public void save(List<Note> notes) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(getFileName()), notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Note> load() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(getFileName()), objectMapper.getTypeFactory().constructCollectionType(List.class, Note.class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

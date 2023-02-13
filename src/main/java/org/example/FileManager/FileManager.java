package org.example.FileManager;

public abstract class FileManager implements Managable{
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

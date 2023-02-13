package org.example.FileManager;

public class FileManagerFactory {
    public FileManager getXMLfileManager(){ return new XMLFileManager("notes.xml"); }

    public FileManager getTXTfileManager(){ return new TXTFileManager("notes.txt"); }

    public FileManager getJSONfileManager(){ return new JsonFileManager("notes.json"); }
}

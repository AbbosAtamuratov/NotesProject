package org.example.FileManager;

import org.example.Note.Note;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;

public class XMLFileManager extends FileManager implements Managable{

    public XMLFileManager(String fileName) {
        super(fileName);
    }

    public void save(List<Note> notes){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(NoteListWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            NoteListWrapper wrapper = new NoteListWrapper();
            wrapper.setNotes(notes);

            jaxbMarshaller.marshal(wrapper, new File(getFileName()));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> load() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NoteListWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            NoteListWrapper wrapper = (NoteListWrapper) jaxbUnmarshaller.unmarshal(new File(getFileName()));

            return wrapper.getNotes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @XmlRootElement(name = "notes")
    private class NoteListWrapper{
        private List<Note> notes;

        @XmlElement(name = "note")
        public List<Note> getNotes() {
            return notes;
        }
        public void setNotes(List<Note> notes) {
            this.notes = notes;
        }
    }
}

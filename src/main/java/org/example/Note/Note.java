package org.example.Note;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.FIELD)
public class Note {
    private String title;
    private String text;
    private int id;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note(String title, String text, int id) {
        this.title = title;
        this.text = text;
        this.id = id;
    }

    public Note() { }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(getId()).append('\n');
        sb.append("Заголовок: ").append(title).append("\n");
        sb.append("Текст:\n").append(text.replaceAll("[.!?]", "$0\n")).append("\n");
        return sb.toString();
    }
}
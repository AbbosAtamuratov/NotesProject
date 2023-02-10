package org.example.Note;

public class Note {
    private String title;
    private String text;

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

    public Note(String title, String text) { setTitle(title); setText(text); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Заголовок: ").append(title).append("\n");
        sb.append("Текст: ").append(text.replace(".", ".\n")).append("\n");
        return sb.toString();
    }
}

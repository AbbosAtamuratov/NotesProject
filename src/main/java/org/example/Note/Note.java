package org.example.Note;

public class Note {
    private String title;
    private String text;
    private static int id=1;

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

    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Note.id = id;
    }

    public Note(String title, String text) { setTitle(title); setText(text); setId(id); id++;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(getId()).append('\n');
        sb.append("Заголовок: ").append(title).append("\n");
        sb.append("Текст: ").append(text.replace(".", ".\n")).append("\n");
        return sb.toString();
    }
}

package org.example.Database;

import org.example.View.Display;

public interface Based {
    void save();
    void create();
    void edit(String id);
    void find(String id);
    void remove(String id);
    public Display getDisplay();
}

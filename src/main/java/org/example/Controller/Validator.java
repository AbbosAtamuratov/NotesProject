package org.example.Controller;

public class Validator {
    public String validateId(String id){
        try {
            int num = Integer.parseInt(id);
            return id;
        } catch (NumberFormatException e) { return e.getMessage(); }
    }
}

package ru.regnums.core.bean;

public class RegisterType {
    
    private int ID = - 1;
    private String title;
    private String generator_class;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGenerator_class() {
        return generator_class;
    }

    public void setGenerator_class(String generator_class) {
        this.generator_class = generator_class;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }        
}

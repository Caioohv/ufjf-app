package com.example.guiacalouros;

public class ClassroomClass {
    private int id;
    private String type;
    private String location;
    private String reference;

    public ClassroomClass(int id, String type, String location, String reference) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}

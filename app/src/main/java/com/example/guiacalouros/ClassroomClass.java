package com.example.guiacalouros;

public class ClassroomClass {
    private int id;
    private String type;
    private String location;
    private String reference;

    private  String codigo;


    public ClassroomClass(int id, String type, String location, String reference, String codigo) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.reference = reference;
        this.codigo = codigo;
    }

    public ClassroomClass() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

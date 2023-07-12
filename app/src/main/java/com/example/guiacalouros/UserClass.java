package com.example.guiacalouros;


class LoggedUser{
    static int id = 0;
    static String name;
    static String email;

    public LoggedUser(int Id, String name, String email){
        id = Id;
        LoggedUser.name = name;
        LoggedUser.email = email;
    }
}

public class UserClass {

    private int id;
    private String name;

    private String cpf;
    private String email;
    private String password;

    private Boolean approved;

    public UserClass(int id, String name, String cpf, String email, String password, boolean approved) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.approved = approved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getApproved(){
        return this.approved;
    }

    public int getId(){return this.id; };
}
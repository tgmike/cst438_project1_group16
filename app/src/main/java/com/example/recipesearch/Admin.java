package com.example.recipesearch;

public class Admin {
    private int id;
    private String username;
    private String password;
    private String email;

    public Admin(){
        username = "Admin";
        password = "password";
        email = "admin@test.com";
    }

    public Admin(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: " + id +" Username: " + username + " Password: " + password + " Email: " + email;
    }
}

package com.example.recipesearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {

    @Test
    public void getUsername(){
        Admin testmin = new Admin();
        String username = testmin.getUsername();
        assertEquals("Admin", username);
    }
    @Test
    public void setUsername(){
        Admin testmin = new Admin();
        testmin.setUsername("username");
        String username = testmin.getUsername();
        assertEquals("username", username);
    }

    @Test
    public void getPassword(){
        Admin testmin = new Admin();
        String password = testmin.getPassword();
        assertEquals("password", password);
    }
    @Test
    public void setPassword(){
        Admin testmin = new Admin();
        testmin.setPassword("123456789");
        String password = testmin.getPassword();
        assertEquals("123456789", password);
    }

    @Test
    public void getEmail(){
        Admin testmin = new Admin();
        String email = testmin.getEmail();
        assertEquals("admin@test.com", email);
    }
    @Test
    public void setEmail(){
        Admin testmin = new Admin();
        testmin.setEmail("admin@gmail.com");
        String email = testmin.getEmail();
        assertEquals("admin@gmail.com", email);
    }
}

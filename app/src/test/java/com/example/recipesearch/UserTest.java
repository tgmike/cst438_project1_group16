package com.example.recipesearch;

import junit.framework.TestCase;

import java.lang.reflect.Field;

public class UserTest extends TestCase {

    public void testTestGetName() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(user, "Frank Lloyd Wright");

        final String result = user.getUsername();

        assertEquals("Frank Lloyd Wright", result);
    }

    public void testTestSetName() throws NoSuchFieldException, IllegalAccessException {
        final User user = new User();

        user.setUsername("Frank Lloyd Wright");

        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(user), "Frank Lloyd Wright");
    }

    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException{
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(user, "frankW@gmail.com");

        final String result = user.getPassword();

        assertEquals("frankW@gmail.com", result);
    }

    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException{
        final User user = new User();

        user.setPassword("frankW@gmail.com");

        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(user), "frankW@gmail.com");
    }

    public void testTestEquals() {
    }

    public void testTestHashCode() {
    }

    public void testTestToString() {
    }
}
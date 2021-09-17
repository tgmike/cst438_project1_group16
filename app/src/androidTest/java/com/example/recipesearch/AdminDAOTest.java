package com.example.recipesearch;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.recipesearch.DAO.adminDAO;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AdminDAOTest {
    private Context appContext;
    private adminDAO myTest;
//    @Test
//    public void adminNukeTest() {
//        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();
//        myTest.nuke();
//
//        assertEquals(myTest.count(), 0);
//        assertEquals("com.example.recipesearch", appContext.getPackageName());
//    }

    @Test
    public void adminInsertTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();
        Admin testmin = new Admin("newAdmin", "newpassword", "newadmin@admin.com");
        testmin.setId(1);
        myTest.insert(testmin);
        Admin realmin = myTest.getAdmin(testmin.getId());

        assertEquals(testmin, realmin);
        myTest.delete(testmin);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }

    @Test
    public void adminCountTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();

        assertEquals(myTest.count(), 0);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }

    @Test
    public void adminUsernameTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();
        Admin testmin = new Admin("newAdmin", "newpassword", "newadmin@admin.com");
        testmin.setId(1);
        myTest.insert(testmin);
        String username = myTest.getAdminUsername(1);

        assertEquals(username, "newAdmin");
        myTest.delete(testmin);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }

    @Test
    public void adminEmailTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();
        Admin testmin = new Admin("newAdmin", "newpassword", "newadmin@admin.com");
        testmin.setId(1);
        myTest.insert(testmin);
        String email = myTest.getAdminEmail(1);

        assertEquals(email, "newadmin@admin.com");
        myTest.delete(testmin);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }

    @Test
    public void adminInsertAllTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();

        Admin testmin1 = new Admin("newAdmin1", "newpassword", "newadmin1@admin.com");
        testmin1.setId(2);
        Admin testmin2 = new Admin("newAdmin2", "newpassword", "newadmin2@admin.com");
        testmin2.setId(3);
        myTest.insertAll(testmin1, testmin2);
        Admin realmin1 = myTest.getAdmin(testmin1.getId());
        Admin realmin2 = myTest.getAdmin(testmin2.getId());

        assertEquals(testmin1, realmin1);
        assertEquals(testmin2, realmin2);
        myTest.delete(testmin1);
        myTest.delete(testmin2);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }

    @Test
    public void adminAllTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();
        Admin testmin1 = new Admin("newAdmin1", "newpassword", "newadmin1@admin.com");
        testmin1.setId(2);
        Admin testmin2 = new Admin("newAdmin2", "newpassword", "newadmin2@admin.com");
        testmin2.setId(3);
        myTest.insertAll(testmin1, testmin2);
        int adminSize = myTest.getAll().size();

        assertEquals(adminSize, 2);
        myTest.delete(testmin1);
        myTest.delete(testmin2);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }

    @Test
    public void adminDeleteTest() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        myTest = Room.databaseBuilder(appContext, recipeDB.class, "recipeDB.db").allowMainThreadQueries().build().getAdminDAO();
        Admin testmin = new Admin("newAdmin", "newpassword", "newadmin@admin.com");
        testmin.setId(1);
        myTest.delete(testmin);

        assertEquals(myTest.count(), 0);
        assertEquals("com.example.recipesearch", appContext.getPackageName());
    }
}
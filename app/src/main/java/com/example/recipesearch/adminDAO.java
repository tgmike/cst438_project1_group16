package com.example.recipesearch;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface adminDAO {

    @Insert
    public void insert(Admin admin);

    @Insert
    void insertAll(Admin... admins);

    @Query("SELECT * FROM admin WHERE id=:id")
    Admin getAdmin(int id);

    @Query("SELECT username FROM admin WHERE id=:id")
    public String getAdminUsername(int id);

    @Query("SELECT email FROM admin WHERE id=:id")
    public String getAdminEmail(int id);

    @Query("SELECT * FROM admin")
    public List<Admin> getAll();

    @Delete
    void delete(Admin admin);

    @Query("SELECT COUNT(*) FROM admin")
    int count();

//    @Query("DELETE FROM admin")
//    public void nuke();
}

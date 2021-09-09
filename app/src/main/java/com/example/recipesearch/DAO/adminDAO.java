package com.example.recipesearch.DAO;

import java.util.ArrayList;
import java.util.List;

import com.example.recipesearch.Admin;

public class adminDAO {
    private List<Admin> admins = new ArrayList<>();

    public void adminDao(){
        admins.add(new Admin());
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public Admin getAdmin(int id){
        for(Admin admin : admins) {
            if(admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

    public String getAdminUsername(int id){
        for(Admin admin : admins) {
            if(admin.getId() == id) {
                return admin.getUsername();
            }
        }
        return null;
    }

    public String getAdminEmail(int id){
        for(Admin admin : admins) {
            if(admin.getId() == id) {
                return admin.getEmail();
            }
        }
        return null;
    }

    public List<Admin> getAll() {
        return admins;
    }

    public void deleteAdmin(Admin admin) {
        admins.remove(admin);
    }
}

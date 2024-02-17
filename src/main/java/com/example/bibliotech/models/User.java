package com.example.bibliotech.models;

import com.example.bibliotech.interfaces.IRole;

public class User implements IRole {

    @Override
    public String getRole() {
        
        return "usuario comum ";
        
    }
    
}

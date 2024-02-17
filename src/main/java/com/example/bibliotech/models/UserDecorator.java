package com.example.bibliotech.models;

import com.example.bibliotech.interfaces.IRole;

public abstract class UserDecorator implements IRole {
    
    protected IRole user;

    public UserDecorator(IRole _user){
        this.user = _user;
    }

    public String getRole(){
        return this.user.getRole();
    }



}

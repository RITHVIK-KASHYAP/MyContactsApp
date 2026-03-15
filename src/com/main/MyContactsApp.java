package com.main;

import java.util.UUID;

import com.repository.*;
import com.user.*;

public class MyContactsApp 
{

    public static void main(String[] args) 
    {

        UserRepository repo = new UserRepository();

        User user = UserFactory.createUser(
                "FREE",UUID.randomUUID().toString(),
                "rithvik@email.com",
                "password123",
                "Rithvik"
        );

        repo.save(user);

        System.out.println("User Registered: " + user.getName());

    }
}
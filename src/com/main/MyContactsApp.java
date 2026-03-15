package com.main;

import java.util.Optional;
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



        // UC-02 Authentication

        AuthenticationStrategy authStrategy = new BasicAuth();

        Optional<User> loggedUser =
                authStrategy.authenticate(
                        "rithvik@email.com",
                        "password123",
                        repo
                );

        if (loggedUser.isPresent()) 
        {

            SessionManager.getInstance().login(loggedUser.get());

            System.out.println("Login Successful: "
                    + loggedUser.get().getName());

        } 
        else 
        {

            System.out.println("Login Failed");

        }

    }
}
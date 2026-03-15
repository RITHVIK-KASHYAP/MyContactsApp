package com.main;

import java.util.Optional;
import java.util.UUID;

import com.repository.*;
import com.user.*;

public class MyContactsApp 
{

	 public static void main(String[] args) {

	        UserRepository repo = new UserRepository();

	        // UC-01 Registration
	        User user = UserFactory.createUser(
	                "FREE",
	                UUID.randomUUID().toString(),
	                "rithvik@email.com",
	                "password123",
	                "Rithvik"
	        );

	        repo.save(user);

	        System.out.println("User Registered: " + user.getName());


	        // UC-02 Authentication

	        AuthenticationStrategy auth = new BasicAuth();

	        Optional<User> logged =
	                auth.authenticate(
	                        "rithvik@email.com",
	                        "password123",
	                        repo
	                );

	        if (logged.isPresent()) {

	            SessionManager.getInstance().login(logged.get());

	            System.out.println("Login Successful");


	            // UC-03 Profile Management

	            CommandManager manager = new CommandManager();

	            manager.executeCommand(new UpdateNameCommand(logged.get(), "Rithvik Kashyap"));

	            manager.executeCommand(new UpdateEmailCommand(logged.get(), "rithvikkashyap@email.com"));

	            manager.undo();   // undo email update

	        }

	    }
	}
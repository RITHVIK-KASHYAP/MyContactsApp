package com.main;

import java.util.Optional;
import java.util.UUID;

import com.repository.*;
import com.user.*;
import com.contact.*;

public class MyContactsApp 
{

	 public static void main(String[] args) {

	        UserRepository repo = new UserRepository();
	        ContactRepository contactRepo = new ContactRepository();

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

	            manager.undo();   

	            Contact contact = ContactFactory.createPerson()
	                            .setName("Rishab")
	                            .addPhone("999888777")
	                            .addEmail("rishab@mail.com")
	                            .build();

				contactRepo.save(contact);

	            System.out.println("Contact Created: " + contact.getName()); 
	            
	            // UC-05 View Contact with Decorators

	            ContactView view = new SimpleContactView(contact);

	            view = new MaskedEmailDecorator(view);
	            view = new UpperCaseDecorator(view);

	            System.out.println("\nContact Details:");
	            System.out.println(view.display());
	            // UC-06 Edit Contact

	            ContactEditor editor = new ContactEditor(contact);

	            editor.execute(new UpdateContactNameCommand(contact, "Shekar"));

	            editor.execute(new AddPhoneCommand(contact, "888777666"));

	            editor.execute(new AddEmailCommand(contact, "shekar.work@mail.com"));
	            // undo last operation

	            editor.undo();
	            // UC-07 Delete Contact

	            ContactLifecycleManager lifecycle = new ContactLifecycleManager(contactRepo);

	            lifecycle.registerObserver(new DeletionLogger());

	            // Soft delete
	            lifecycle.softDelete(contact);

	            // Hard delete
	            lifecycle.hardDelete(contact);

	        }

	    }

	}
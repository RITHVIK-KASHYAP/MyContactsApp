package com.main;

import java.util.Optional;
import java.util.UUID;

import com.repository.*;
import com.search.*;
import com.user.*;
import com.bulk.*;
import com.contact.*;
import com.group.*;


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
	            
	           // UC-08 Groups and Bulk Operations

	            Contact contact2 =
	                    ContactFactory.createPerson()
	                            .setName("Ghouse")
	                            .addPhone("777666555")
	                            .addEmail("bob@mail.com")
	                            .build();

	            contactRepo.save(contact2);

	            // Wrap contacts as leaf nodes

	            ContactLeaf leaf1 = new ContactLeaf(contact);
	            ContactLeaf leaf2 = new ContactLeaf(contact2);

	            // Create group

	            ContactGroup friendsGroup =
	                    new ContactGroup("Friends");

	            friendsGroup.add(leaf1);
	            friendsGroup.add(leaf2);

	            System.out.println("\nDisplaying Group:");

	            friendsGroup.display();

	            // Bulk delete example

	            BulkDeleteService bulkDelete = new BulkDeleteService(contactRepo);

	            bulkDelete.delete(leaf1);
	           // UC-09 Search Contacts

	            ContactSearchService searchService =  new ContactSearchService();

	            // search by name

	            NameSpecification nameSpec =  new NameSpecification("Ghouse");

	            System.out.println("\nSearch by Name:");

	            searchService.search(contactRepo.findAll().values(), nameSpec)
	                    .forEach(c -> System.out.println(c.getName()));


	            // combined search

	            PhoneSpecification phoneSpec = new PhoneSpecification("777");

	            AndSpecification combined =   new AndSpecification(nameSpec, phoneSpec);

	            System.out.println("\nSearch Name + Phone:");

	            searchService
	                    .search(contactRepo.findAll().values(), combined)
	                    .forEach(c -> System.out.println(c.getName()));

	        }

	    }

	}
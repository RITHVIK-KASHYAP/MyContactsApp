package com.contact;

public class UpdateContactNameCommand implements ContactCommand 
{

    private Contact contact;
    private String newName;

    public UpdateContactNameCommand(Contact contact, String newName) 
    {
        this.contact = contact;
        this.newName = newName;
    }

    @Override
    public void execute() 
    {

        contact.setName(newName);

        System.out.println("Contact name updated to " + newName);

    }

}
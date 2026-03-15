package com.contact;

public class AddEmailCommand implements ContactCommand 
{

    private Contact contact;
    private String email;

    public AddEmailCommand(Contact contact, String email) 
    {
        this.contact = contact;
        this.email = email;
    }

    @Override
    public void execute() 
    {

        contact.addEmail(new Email(email));

        System.out.println("Email added: " + email);

    }

}
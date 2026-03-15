package com.group;

import com.contact.*;

public class ContactLeaf implements ContactComponent 
{

    private Contact contact;

    public ContactLeaf(Contact contact) 
    {
        this.contact = contact;
    }

    @Override
    public void display() 
    {

        System.out.println("Contact: " + contact.getName());

    }

    public Contact getContact() 
    {
        return contact;
    }

}
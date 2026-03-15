package com.contact;

import java.util.ArrayList;
import java.util.List;

public class ContactMemento 
{

    private String name;

    private List<PhoneNumber> phones;
    private List<Email> emails;

    public ContactMemento(Contact contact) 
    {

        this.name = contact.getName();

        this.phones = new ArrayList<>(contact.getPhones());
        this.emails = new ArrayList<>(contact.getEmails());

    }

    public String getName() 
    {
        return name;
    }

    public List<PhoneNumber> getPhones() 
    {
        return phones;
    }

    public List<Email> getEmails() 
    {
        return emails;
    }

}
package com.contact;

import java.util.ArrayList;
import java.util.List;

public abstract class ContactBuilder 
{

    protected String name;

    protected List<PhoneNumber> phones = new ArrayList<>();
    protected List<Email> emails = new ArrayList<>();

    public ContactBuilder setName(String name) 
    {
        this.name = name;
        return this;
    }

    public ContactBuilder addPhone(String number) 
    {

        phones.add(new PhoneNumber(number));
        return this;

    }

    public ContactBuilder addEmail(String email) 
    {

        emails.add(new Email(email));
        return this;

    }

    public abstract Contact build();

}
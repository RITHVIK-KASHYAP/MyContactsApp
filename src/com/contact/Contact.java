package com.contact;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Contact 
{

    private String id;
    private String name;

    private List<PhoneNumber> phones = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();

    private LocalDateTime createdAt;

    public Contact(String name) 
    {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.createdAt = LocalDateTime.now();

    }

    public void addPhone(PhoneNumber phone) 
    {
        phones.add(phone);
    }

    public void addEmail(Email email) 
    {
        emails.add(email);
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

    public String getId()
    {
        return id;
    }

    public LocalDateTime getCreatedAt() 
    {
        return createdAt;
    }

}
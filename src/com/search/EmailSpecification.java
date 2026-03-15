package com.search;

import com.contact.*;

public class EmailSpecification implements ContactSpecification 
{

    private String email;

    public EmailSpecification(String email) 
    {
        this.email = email.toLowerCase();
    }

    @Override
    public boolean isSatisfiedBy(Contact contact) 
    {

        for (Email e : contact.getEmails()) 
        {

            if (e.getEmail().toLowerCase().contains(email)) 
            {
                return true;
            }

        }

        return false;

    }

}
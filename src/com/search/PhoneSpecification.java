package com.search;

import com.contact.*;

public class PhoneSpecification implements ContactSpecification 
{

    private String phone;

    public PhoneSpecification(String phone) 
    {
        this.phone = phone;
    }

    @Override
    public boolean isSatisfiedBy(Contact contact) 
    {

        for (PhoneNumber p : contact.getPhones()) 
        {

            if (p.getNumber().contains(phone)) 
            {
                return true;
            }

        }

        return false;

    }

}
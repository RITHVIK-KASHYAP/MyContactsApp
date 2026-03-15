package com.search;

import com.contact.*;

public class NameSpecification implements ContactSpecification
{

    private String name;

    public NameSpecification(String name) 
    {
        this.name = name.toLowerCase();
    }

    @Override
    public boolean isSatisfiedBy(Contact contact) 
    {
    	
        return contact.getName().toLowerCase().contains(name);

    }

}
package com.search;

import com.contact.*;

public class AndSpecification implements ContactSpecification 
{

    private ContactSpecification first;
    private ContactSpecification second;

    public AndSpecification(ContactSpecification first,
                            ContactSpecification second)
    {

        this.first = first;
        this.second = second;

    }

    @Override
    public boolean isSatisfiedBy(Contact contact) 
    {

        return first.isSatisfiedBy(contact)
                && second.isSatisfiedBy(contact);

    }

}
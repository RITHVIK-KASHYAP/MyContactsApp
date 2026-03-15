package com.search;

import java.util.*;
import com.contact.*;

public class ContactSearchService 
{

    public List<Contact> search(Collection<Contact> contacts,
                                ContactSpecification specification) 
    {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) 
        {

            if (specification.isSatisfiedBy(c)) 
            {

                result.add(c);

            }

        }

        return result;

    }

}
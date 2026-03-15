package com.tag;

import java.util.*;

import com.contact.*;


public class TagSearchService 
{

    public List<Contact> searchByTag(Collection<Contact> contacts,
                                     String tagName) 
    {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts)
        {

            for (Tag tag : c.getTags()) 
            {

                if (tag.getName().equalsIgnoreCase(tagName)) 
                {

                    result.add(c);

                }

            }

        }

        return result;

    }

}

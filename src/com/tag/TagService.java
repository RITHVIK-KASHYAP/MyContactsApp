package com.tag;

import com.contact.*;

public class TagService 
{

    public void addTag(Contact contact, String tagName) 
    {

        Tag tag = TagFactory.getTag(tagName);

        contact.addTag(tag);

        System.out.println("Tag added: " + tag.getName());

    }

}
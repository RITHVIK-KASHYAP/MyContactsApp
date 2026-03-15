package com.tag;

import com.contact.*;

public class TagService 
{

    private TagChangeManager manager;

    public TagService(TagChangeManager manager) 
    {

        this.manager = manager;

    }

    public void addTag(Contact contact, String tagName) 
    {

        Tag tag = TagFactory.getTag(tagName);

        contact.addTag(tag);

        manager.notifyTagAdded(contact.getName(), tagName);

    }

}
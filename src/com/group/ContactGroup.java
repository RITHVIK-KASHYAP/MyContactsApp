package com.group;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup implements ContactComponent 
{

    private String groupName;

    private List<ContactComponent> members = new ArrayList<>();

    public ContactGroup(String groupName) 
    {
        this.groupName = groupName;
    }

    public void add(ContactComponent component) 
    {

        members.add(component);

    }

    public void remove(ContactComponent component) 
    {

        members.remove(component);

    }

    @Override
    public void display() 
    {

        System.out.println("Group: " + groupName);

        for (ContactComponent c : members) 
        {

            c.display();

        }

    }

}
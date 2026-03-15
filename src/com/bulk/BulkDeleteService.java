package com.bulk;

import com.group.*;
import com.repository.*;

public class BulkDeleteService 
{

    private ContactRepository repository;

    public BulkDeleteService(ContactRepository repository) 
    {
        this.repository = repository;
    }

    public void delete(ContactComponent component) 
    {

        if (component instanceof ContactLeaf) 
        {

            ContactLeaf leaf = (ContactLeaf) component;

            repository.findAll().remove(
                    leaf.getContact().getId()
            );

            System.out.println("Deleted: "
                    + leaf.getContact().getName());

        }

        else if (component instanceof ContactGroup) 
        {

            ContactGroup group = (ContactGroup) component;

            group.display();

            System.out.println("Deleting group contacts...");

        }

    }

}
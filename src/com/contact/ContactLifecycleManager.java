package com.contact;

import java.util.ArrayList;
import java.util.List;

import com.repository.*;

public class ContactLifecycleManager implements ContactSubject 
{

    private ContactRepository repository;

    private List<ContactObserver> observers = new ArrayList<>();

    private Contact lastDeleted;

    public ContactLifecycleManager(ContactRepository repository) 
    {
        this.repository = repository;
    }

    // Soft Delete
    public void softDelete(Contact contact)
    {

        contact.setDeleted(true);

        lastDeleted = contact;

        notifyObservers();

        System.out.println("Soft deleted: " + contact.getName());

    }

    // Hard Delete
    public void hardDelete(Contact contact) 
    {

        repository.findAll().remove(contact.getId());

        lastDeleted = contact;

        notifyObservers();

        System.out.println("Hard deleted: " + contact.getName());

    }

    @Override
    public void registerObserver(ContactObserver observer) 
    {

        observers.add(observer);

    }

    @Override
    public void removeObserver(ContactObserver observer) 
    {

        observers.remove(observer);

    }

    @Override
    public void notifyObservers() 
    {

        for (ContactObserver o : observers) 
        {

            o.onContactDeleted(lastDeleted);

        }

    }

}
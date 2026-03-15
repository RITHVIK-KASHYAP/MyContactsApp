package com.contact;

public class DeletionLogger implements ContactObserver 
{

    @Override
    public void onContactDeleted(Contact contact) 
    {

        System.out.println("LOG: Contact deleted -> " + contact.getName());

    }

}
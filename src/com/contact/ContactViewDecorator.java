package com.contact;

public abstract class ContactViewDecorator implements ContactView 
{

    protected ContactView view;

    public ContactViewDecorator(ContactView view) 
    {
        this.view = view;
    }

}
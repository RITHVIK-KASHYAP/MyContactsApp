package com.contact;

public class Person extends Contact 
{

    private String lastName;

    public Person(String name, String lastName) 
    {

        super(name);
        this.lastName = lastName;

    }

    public String getLastName() 
    {
        return lastName;
    }

}
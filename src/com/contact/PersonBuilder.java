package com.contact;

public class PersonBuilder extends ContactBuilder 
{

    private String lastName;

    public PersonBuilder setLastName(String lastName) 
    {

        this.lastName = lastName;
        return this;

    }

    @Override
    public Contact build() 
    {

        Person person = new Person(name, lastName);

        phones.forEach(person::addPhone);
        emails.forEach(person::addEmail);

        return person;

    }

}
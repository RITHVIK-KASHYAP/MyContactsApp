package com.contact;

public class ContactFactory 
{

    public static PersonBuilder createPerson() 
    {
        return new PersonBuilder();
    }

    public static OrganizationBuilder createOrganization() 
    {
        return new OrganizationBuilder();
    }

}
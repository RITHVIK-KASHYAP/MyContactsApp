package com.contact;

public class Organization extends Contact
{

    private String company;

    public Organization(String name, String company) 
    {

        super(name);
        this.company = company;

    }

    public String getCompany() 
    {
        return company;
    }

}
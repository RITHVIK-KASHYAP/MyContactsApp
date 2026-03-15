package com.contact;


public class OrganizationBuilder extends ContactBuilder 
{

    private String company;

    public OrganizationBuilder setCompany(String company) 
    {

        this.company = company;
        return this;

    }

    @Override
    public Contact build() 
    {

        Organization org = new Organization(name, company);

        phones.forEach(org::addPhone);
        emails.forEach(org::addEmail);

        return org;

    }

}
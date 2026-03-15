package com.contact;

public class SimpleContactView implements ContactView 
{

    private Contact contact;

    public SimpleContactView(Contact contact) 
    {
        this.contact = contact;
    }

    @Override
    public String display() 
    {

        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(contact.getName()).append("\n");

        sb.append("Phones: ");
        contact.getPhones().forEach(p ->
                sb.append(p.getNumber()).append(" ")
        );

        sb.append("\nEmails: ");
        contact.getEmails().forEach(e ->
                sb.append(e.getEmail()).append(" ")
        );

        return sb.toString();
    }
}
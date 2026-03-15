package com.contact;

public class AddPhoneCommand implements ContactCommand 
{

    private Contact contact;
    private String number;

    public AddPhoneCommand(Contact contact, String number) 
    {
        this.contact = contact;
        this.number = number;
    }

    @Override
    public void execute()
    {

        contact.addPhone(new PhoneNumber(number));

        System.out.println("Phone added: " + number);

    }

}
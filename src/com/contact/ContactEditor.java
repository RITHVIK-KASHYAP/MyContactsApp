package com.contact;

public class ContactEditor 
{

    private Contact contact;

    private ContactHistory history = new ContactHistory();

    public ContactEditor(Contact contact) 
    {
        this.contact = contact;
    }

    public void execute(ContactCommand command) 
    {

        history.save(new ContactMemento(contact));

        command.execute();

    }

    public void undo() 
    {

        ContactMemento memento = history.undo();

        if (memento != null) 
        {

            contact.setName(memento.getName());

            contact.getPhones().clear();
            contact.getPhones().addAll(memento.getPhones());

            contact.getEmails().clear();
            contact.getEmails().addAll(memento.getEmails());

            System.out.println("Undo successful");

        }

    }

}
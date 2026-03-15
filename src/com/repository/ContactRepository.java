package com.repository;

import java.util.HashMap;
import java.util.Map;

import com.contact.*;

public class ContactRepository {

    private Map<String, Contact> contacts = new HashMap<>();

    public void save(Contact contact) {

        contacts.put(contact.getId(), contact);

    }

    public Map<String, Contact> findAll() {
        return contacts;
    }

}
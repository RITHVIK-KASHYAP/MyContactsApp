package com.filter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.contact.*;

public class NameSortStrategy implements SortStrategy 
{

    @Override
    public List<Contact> sort(List<Contact> contacts) 
    {

        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toList());

    }

}
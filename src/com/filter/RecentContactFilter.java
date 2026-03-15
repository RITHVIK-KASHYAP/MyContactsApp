package com.filter;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.contact.*;

public class RecentContactFilter implements FilterStrategy 
{

    @Override
    public List<Contact> apply(List<Contact> contacts) 
    {

        LocalDateTime limit = LocalDateTime.now().minusDays(1);

        return contacts.stream()
                .filter(c -> c.getCreatedAt().isAfter(limit))
                .collect(Collectors.toList());

    }

}
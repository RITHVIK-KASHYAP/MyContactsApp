package com.filter;

import java.util.List;

import com.contact.*;

public class ContactFilterContext 
{

    private FilterStrategy filterStrategy;

    private SortStrategy sortStrategy;

    public void setFilterStrategy(FilterStrategy filterStrategy) 
    {
        this.filterStrategy = filterStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) 
    {
        this.sortStrategy = sortStrategy;
    }

    public List<Contact> execute(List<Contact> contacts) 
    {

        if (filterStrategy != null)
        {
            contacts = filterStrategy.apply(contacts);
        }

        if (sortStrategy != null) 
        {
            contacts = sortStrategy.sort(contacts);
        }

        return contacts;

    }

}
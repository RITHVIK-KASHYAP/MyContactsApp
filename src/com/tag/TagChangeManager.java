package com.tag;

import java.util.ArrayList;
import java.util.List;

public class TagChangeManager implements TagSubject 
{

    private List<TagObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(TagObserver observer) 
    {

        observers.add(observer);

    }

    @Override
    public void notifyTagAdded(String contactName, String tag)
    {

        for (TagObserver o : observers) 
        {

            o.onTagAdded(contactName, tag);

        }

    }

}
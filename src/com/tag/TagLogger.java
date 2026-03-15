package com.tag;

public class TagLogger implements TagObserver
{

    @Override
    public void onTagAdded(String contactName, String tag) 
    {

        System.out.println(
                "Tag '" + tag + "' added to contact: " + contactName
        );

    }

}
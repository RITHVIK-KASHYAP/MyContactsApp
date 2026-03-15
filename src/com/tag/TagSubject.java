package com.tag;


public interface TagSubject 
{

    void registerObserver(TagObserver observer);

    void notifyTagAdded(String contactName, String tag);

}
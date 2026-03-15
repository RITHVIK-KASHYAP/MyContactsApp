package com.contact;

public interface ContactSubject
{

    void registerObserver(ContactObserver observer);

    void removeObserver(ContactObserver observer);

    void notifyObservers();

}
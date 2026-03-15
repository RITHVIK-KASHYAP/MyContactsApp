package com.filter;

import java.util.List;

import com.contact.*;

public interface FilterStrategy 
{

    List<Contact> apply(List<Contact> contacts);

}
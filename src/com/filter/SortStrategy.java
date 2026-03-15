package com.filter;

import java.util.List;

import com.contact.*;

public interface SortStrategy {

    List<Contact> sort(List<Contact> contacts);

}
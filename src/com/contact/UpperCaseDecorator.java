package com.contact;

public class UpperCaseDecorator extends ContactViewDecorator 
{

    public UpperCaseDecorator(ContactView view) 
    {
        super(view);
    }

    @Override
    public String display() 
    {

        return view.display().toUpperCase();

    }

}
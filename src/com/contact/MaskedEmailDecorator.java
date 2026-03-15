package com.contact;

public class MaskedEmailDecorator extends ContactViewDecorator 
{

    public MaskedEmailDecorator(ContactView view) 
    {
        super(view);
    }

    @Override
    public String display() 
    {

        String result = view.display();

        return result.replaceAll(
                "([a-zA-Z])[a-zA-Z0-9._%+-]*@",
                "$1****@"
        );

    }

}
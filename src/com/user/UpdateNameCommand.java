package com.user;

public class UpdateNameCommand implements ProfileCommand 
{

    private User user;
    private String newName;
    private String oldName;

    public UpdateNameCommand(User user, String newName) 
    {
        this.user = user;
        this.newName = newName;
    }

    @Override
    public void execute() 
    {

        oldName = user.getName();
        user.setName(newName);

        System.out.println("Name updated to: " + newName);
    }

    @Override
    public void undo() 
    {

        user.setName(oldName);
        System.out.println("Undo Name → " + oldName);

    }

}
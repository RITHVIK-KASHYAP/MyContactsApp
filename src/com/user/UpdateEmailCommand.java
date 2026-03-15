package com.user;

public class UpdateEmailCommand implements ProfileCommand 
{

    private User user;
    private String newEmail;
    private String oldEmail;

    public UpdateEmailCommand(User user, String newEmail) 
    {
        this.user = user;
        this.newEmail = newEmail;
    }

    @Override
    public void execute() 
    {

        oldEmail = user.getEmail();
        user.setEmail(newEmail);

        System.out.println("Email updated to: " + newEmail);

    }

    @Override
    public void undo() 
    {

        user.setEmail(oldEmail);

        System.out.println("Undo Email → " + oldEmail);

    }

}
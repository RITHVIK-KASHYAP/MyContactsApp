package com.user;

public class ChangePasswordCommand implements ProfileCommand 
{

    private User user;
    private String newPassword;

    public ChangePasswordCommand(User user, String newPassword) 
    {
        this.user = user;
        this.newPassword = newPassword;
    }

    @Override
    public void execute() 
    {

        user.changePassword(newPassword);

        System.out.println("Password updated");

    }

    @Override
    public void undo() 
    {

        System.out.println("Password undo not supported for security");

    }

}
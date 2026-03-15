package com.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User 
{

    private String userId;
    private String email;
    private String passwordHash;
    private String name;

    protected User(String userId, String email, String password, String name) 
    {
        this.userId = userId;
        this.email = email;
        this.passwordHash = hashPassword(password);
        this.name = name;
    }

    private String hashPassword(String password) 
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) 
        {
            throw new RuntimeException("Hashing failed");
        }
    }

    public String getEmail() 
    {
        return email;
    }

    public boolean verifyPassword(String password) 
    {
        return passwordHash.equals(hashPassword(password));
    }

    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public void changePassword(String newPassword) 
    {
        this.passwordHash = hashPassword(newPassword);
    }

}
package com.user;

public abstract class UserBuilder 
{

    protected String id;
    protected String email;
    protected String password;
    protected String name;

    public UserBuilder setId(String id) 
    {
        this.id = id;
        return this;
    }

    public UserBuilder setEmail(String email) 
    {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) 
    {
        this.password = password;
        return this;
    }

    public UserBuilder setName(String name) 
    {
        this.name = name;
        return this;
    }

    public abstract User build();

}
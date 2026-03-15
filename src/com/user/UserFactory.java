package com.user;

public class UserFactory 
{

    public static User createUser(String type,
                                  String id,
                                  String email,
                                  String password,
                                  String name) 
    {

        switch (type) 
        {

            case "FREE":
                return new FreeUser(id, email, password, name);

            case "PREMIUM":
                return new PremiumUser(id, email, password, name);

            default:
                throw new IllegalArgumentException("Unknown user type");

        }

    }

}
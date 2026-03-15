package com.repository;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.user.*;

public class UserRepository 
{

    private Map<String, User> users = new HashMap<>();

    public void save(User user) 
    {
        users.put(user.getEmail(), user);
    }

    public Optional<User> findByEmail(String email) 
    {
        return Optional.ofNullable(users.get(email));
    }

}
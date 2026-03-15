package com.user;

import java.util.Optional;

import com.repository.*;

public class BasicAuth implements AuthenticationStrategy 
{

    @Override
    public Optional<User> authenticate(String email,
                                       String password,
                                       UserRepository repository) 
    {

        Optional<User> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) 
        {

            User user = userOptional.get();

            if (user.verifyPassword(password)) 
            {
                return Optional.of(user);
            }

        }

        return Optional.empty();
    }

}
package com.user;

import java.util.Optional;

import com.repository.*;

public class OAuth implements AuthenticationStrategy 
{

    @Override
    public Optional<User> authenticate(String email,
                                       String token,
                                       UserRepository repository) 
    {

        Optional<User> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) 
        {

            if (token.equals("OAUTH_TOKEN")) 
            {
                return userOptional;
            }

        }

        return Optional.empty();
    }

}
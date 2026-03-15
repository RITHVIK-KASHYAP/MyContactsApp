package com.user;

import java.util.Optional;

import com.repository.*;

public interface AuthenticationStrategy 
{

    Optional<User> authenticate(String email,
                                String password,
                                UserRepository repository);

}
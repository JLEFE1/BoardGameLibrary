package com.homegrown.service;

import com.homegrown.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by JoLe on 12/01/2017.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}

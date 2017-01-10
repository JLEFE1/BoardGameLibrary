package com.homegrown.channel;

import com.homegrown.entity.User;
import com.homegrown.repository.UserRepository;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by JoLe on 18/12/2016.
 */
@MessageEndpoint
public class UserProcessor {

    private final UserRepository userRepository;

    public UserProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ServiceActivator(inputChannel = "input")
    public void acceptNewUsers(String firstName){
        this.userRepository.save(new User(firstName));
    }
}
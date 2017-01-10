package com.homegrown.controller;

import com.homegrown.entity.User;
import com.homegrown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by JoLe on 18/12/2016.
 */
@Component
public class DummyCLR implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DummyCLR(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Stream.of("Joris","An","Tom","Jan")
        .forEach(firstName -> userRepository.save(new User(firstName)));

        userRepository.findAll().forEach(System.out::println);
    }

}

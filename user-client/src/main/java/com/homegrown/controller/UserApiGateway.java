package com.homegrown.controller;

import com.homegrown.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by JoLe on 18/12/2016.
 */
@RestController
@RequestMapping("/users")
public class UserApiGateway {

    private final RestTemplate restTemplate;

    @Autowired
    public UserApiGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Collection<String> fallback(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void write(@RequestBody User user){

    }


    //TODO This method does not work
    // https://www.youtube.com/watch?v=fxB0tVnAi0I
    // around 1u30
    // Adding the @LoadBalanced to restTemplate creation solved this issue
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/firstNames")
    public Collection<String> userNames(){

        ParameterizedTypeReference<Resources<User>> ptr =
                new ParameterizedTypeReference<Resources<User>>() {
                };

        ResponseEntity<Resources<User>> responseEntity =
            this.restTemplate.exchange("http://user-service/users",
                HttpMethod.GET ,
                null,
                ptr);

        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(User::getFirstName)
                .collect(Collectors.toList());

    }

}

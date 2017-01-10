package com.homegrown.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JoLe on 18/12/2016.
 */
@RefreshScope
@RestController
public class MessageController {

    @Value("${message}")
    private String message;

    @GetMapping(value = "/message")
    String msg(){
        return this.message;
    }

}

package com.homegrown.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by JoLe on 18/12/2016.
 */
public interface UserClient {

    @Output
    MessageChannel output();

}

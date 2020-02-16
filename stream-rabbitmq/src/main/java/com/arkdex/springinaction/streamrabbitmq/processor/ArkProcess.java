package com.arkdex.springinaction.streamrabbitmq.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ArkProcess {
    String INPUT = "arkInput";

    @Input
    SubscribableChannel arkInput();

    @Output("arkOutput")
    MessageChannel arkOutput();

    @Output
    MessageChannel anotherOutput();
}

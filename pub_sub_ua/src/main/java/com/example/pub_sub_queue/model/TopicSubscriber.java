package com.example.pub_sub_queue.model;

import java.util.concurrent.atomic.AtomicInteger;

import com.example.pub_sub_queue.public_interface.ISubscriber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopicSubscriber {
    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public TopicSubscriber(final ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

}

package com.example.pub_sub_queue.handler;

import com.example.pub_sub_queue.model.Message;
import com.example.pub_sub_queue.model.Topic;
import com.example.pub_sub_queue.model.TopicSubscriber;

import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;

@Getter
public class SubscriberWorker implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(@NonNull final Topic topic, @NonNull final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int cutOffset = topicSubscriber.getOffset().get();
                while(cutOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                Message message = topic.getMessages().get(cutOffset);
                topicSubscriber.getSubscriber().consume(message);
                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(cutOffset, cutOffset + 1);
            } while(true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}

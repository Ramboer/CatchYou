package com.liu.CatchYou.common.event;

import org.junit.Test;

/**
 * Created by xu.liu on 2017-06-21.
 */
public class EventTest {
    @Test
    public void testEventReceive() {
        MessageEventListener messageListener = new MessageEventListener("messageListener");
        ApplicationEventBus.register(messageListener);
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setMessageInfo("success");
        messageEvent.setMessageName("1050");
        ApplicationEventBus.post(messageEvent);
        MessageEventListener listener = (MessageEventListener) ApplicationEventBus.getListener("messageListener");
        System.out.println(listener.getMessageName() + " : " + listener.getMessageInfo());

    }
}

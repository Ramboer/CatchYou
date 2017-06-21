package com.liu.CatchYou.common.Event;

import com.google.common.eventbus.Subscribe;

/**
 * Created by xu.liu on 2017-06-21.
 */
public class MessageEventListener implements Listener {
    private String listenerName;
    private String messageName;
    private String MessageInfo;

    public MessageEventListener(String listenerName) {
        this.listenerName = listenerName;
    }

    public String getName() {
        return this.listenerName;
    }
    @Subscribe
    public void listen(MessageEvent messageEvent) {
        this.messageName = messageEvent.getMessageName();
        this.MessageInfo = messageEvent.getMessageInfo();
    }

    public String getMessageName() {
        return messageName;
    }

    public String getMessageInfo() {
        return MessageInfo;
    }
}

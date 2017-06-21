package com.liu.CatchYou.common.Event;

/**
 * Created by xu.liu on 2017-06-21.
 */
public class MessageEvent implements Event {
    private String messageName;
    private String messageInfo;

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }
}

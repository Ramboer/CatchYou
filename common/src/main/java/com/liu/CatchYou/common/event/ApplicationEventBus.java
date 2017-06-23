package com.liu.CatchYou.common.event;

import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;

import java.util.Map;

/**
 * Created by xu.liu on 2017-06-21.
 */
public class ApplicationEventBus {
    private static final EventBus instance = new EventBus();
    private static  Map<String, Listener> listenerMap = Maps.newConcurrentMap();

    public static void register(Listener listener) {
        instance.register(listener);
        listenerMap.put(listener.getName(), listener);
    }

    public static void unregister(Listener listener) {
        if (listenerMap.containsKey(listener.getName())) {
            instance.unregister(listener);
            listenerMap.remove(listener.getName());
        }
    }

    public static EventBus getInstance() {
        return instance;
    }

    public static void  post(Event event) {
        instance.post(event);
    }

    public static Listener getListener(String name) {
         if (listenerMap.get(name) != null) {
             return listenerMap.get(name);
         }

         return null;
    }
}

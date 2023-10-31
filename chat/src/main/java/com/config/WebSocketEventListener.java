package com.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/* 1. This is to be made a Component by adding Component Annotation
 * 2. Slf4j is used for Logging because i want to maintain a log when a user leaves the chat
*/

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    // To make this event Listener we will add an EventListener Annotation
    @EventListener
    public void handleWebSocketDisconnentListener(SessionDisconnectEvent event) {
        // Todo implemented later basically here we will be implementing when any user
        // disconnects then other users are informed about it

    }
}

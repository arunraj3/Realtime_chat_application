package com.websocket_chat.chat.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


import com.websocket_chat.chat.chat.*;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/* 1. This is to be made a Component by adding Component Annotation
 * 2. Slf4j is used for Logging because i want to maintain a log when a user leaves the chat
*/

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageTemplate;

    // To make this event Listener we will add an EventListener Annotation
    @EventListener
    public void handleWebSocketDisconnentListener(SessionDisconnectEvent event) {
        // Todo implemented later basically here we will be implementing when any user
        // disconnects then other users are informed about it
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null){
            log.info("User disconnected: {}", username);
            var chatMesssage = ChatMessage.builder().type(MessageType.LEAVE).sender(username).build();

            messageTemplate.convertAndSend("/topic/public",chatMesssage);

        }
    }
}

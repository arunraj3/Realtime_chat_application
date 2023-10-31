package com.websocket_chat.chat.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/* This class is going to controller 
 * 
 * we need to create two methods 
 *          1. Method to add user 
 *          2. Method to send Message
 */

@Controller
public class ChatController {

    // message mapping tells for which URL should i invoke this method
    @MessageMapping("./chat.sendMessage")
    @SendTo("./topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {

        /* We need to create Payload */
        /*
         * So basically for REST API's we mark as it as the RequestBody in classic
         * RESTAPI but now we are talking about the websockets so we add it as Payload
         * 
         */
        return chatMessage;
    }

    @MessageMapping("./chat.addUser")
    @SendTo("./topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}

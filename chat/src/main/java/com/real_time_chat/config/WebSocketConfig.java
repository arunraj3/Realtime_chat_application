package com.real_time_chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/* step : 1  
1.1 Adding Configuration Annotation to make it Configuration class 
1.2 Adding EnableWebSocketMessageBroker Annotation to enable the WebSocket in this project*/

/* step : 2
 * Implement an Interface i.e WebSocketMessageBrokerConfigurer it consist of two default methods we should be using in our class 
 *  Methods to be implemented or override  in this class are :
 *          1. registerStompEndpoints which takes StompEndpointRegistry as parameter to be passed 
 *          2. configureMessageBroker which takes MessageBrokerRegistry as parameter to be passed 
 * 
 * 
 * 1. registerStompEndpoints basically tells to we want to add new Stomp points to our websocket configuration
 * it may be /ws or /wss (secure)
 * 
 * 2. configureMessageBroker this is point where we want to add the application destination prefixes  
 *  Now this configuration is complete next we want to create an event listener
 *
 * Basically it will listen to the session disconnection and tells the other user that the particular user has left the chat 
 * so left create a class WebSocketEventListen
 */

// This is Basically the configuration class 
@Configuration
// we will enabling Websocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

}

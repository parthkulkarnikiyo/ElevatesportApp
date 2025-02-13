
// package com.sportapi.config;
// // // import org.springframework.context.annotation.Bean;
// // // import org.springframework.context.annotation.Configuration;
// // // import org.springframework.web.cors.CorsConfiguration;
// // // import org.springframework.web.cors.CorsConfigurationSource;
// // // import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// // // import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// // // import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// // // import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.messaging.simp.config.MessageBrokerRegistry;
// import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// // // @Configuration
// // // @EnableWebSocketMessageBroker
// // // public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

// // //     @Override
// // //     public void registerStompEndpoints(StompEndpointRegistry registry) {
// // //         registry.addEndpoint("/ws")
// // //                 .setAllowedOriginPatterns("*") ;// Allow requests from any origin
// // // //                .withSockJS();
// // //     }

// // //     @Bean
// // //     public CorsConfigurationSource corsConfigurationSource() {
// // //         CorsConfiguration configuration = new CorsConfiguration();
// // //         configuration.setAllowCredentials(false); // Set to true only if needed
// // //         configuration.addAllowedOrigin("*"); // Allow requests from any origin
// // //         configuration.addAllowedHeader("*");
// // //         configuration.addAllowedMethod("*");

// // //         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// // //         source.registerCorsConfiguration("/ws/**", configuration); // Apply CORS only to WebSocket endpoint
// // //         return source;
// // //     }
// // // }
// // // //


// // latest test

// @Configuration
// @EnableWebSocketMessageBroker
// public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//     @Override
//     public void registerStompEndpoints(StompEndpointRegistry registry) {
//         registry.addEndpoint("/ws").setAllowedOriginPatterns("*")
//         .withSockJS();
//     }

//     @Override
//     public void configureMessageBroker(MessageBrokerRegistry registry) {
//         registry.enableSimpleBroker("/topic");
//         registry.setApplicationDestinationPrefixes("/app");
//     }
// }


// // basic old conection


// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.web.cors.CorsConfiguration;
// // import org.springframework.web.cors.CorsConfigurationSource;
// // import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// // import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// // import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// // import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// // @Configuration
// // @EnableWebSocketMessageBroker
// // public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

// //     @Override
// //     public void registerStompEndpoints(StompEndpointRegistry registry) {
// //         registry.addEndpoint("/ws")
// //                 .setAllowedOriginPatterns("*") ;// Allow requests from any origin
// // //                .withSockJS();
// //     }

// //     @Bean
// //     public CorsConfigurationSource corsConfigurationSource() {
// //         CorsConfiguration configuration = new CorsConfiguration();
// //         configuration.setAllowCredentials(false); // Set to true only if needed
// //         configuration.addAllowedOrigin("*"); // Allow requests from any origin
// //         configuration.addAllowedHeader("*");
// //         configuration.addAllowedMethod("*");

// //         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// //         source.registerCorsConfiguration("/ws/**", configuration); // Apply CORS only to WebSocket endpoint
// //         return source;
// //     }
// // }


// // last working
// package com.sportapi.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// @Configuration
// @EnableWebSocketMessageBroker
// public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

// @Override
// public void registerStompEndpoints(StompEndpointRegistry registry) {
// registry.addEndpoint("/ws")
// .setAllowedOriginPatterns("*") ;// Allow requests from any origin
// // .withSockJS();
// }

// @Bean
// public CorsConfigurationSource corsConfigurationSource() {
// CorsConfiguration configuration = new CorsConfiguration();
// configuration.setAllowCredentials(false); // Set to true only if needed
// configuration.addAllowedOrigin("*"); // Allow requests from any origin
// configuration.addAllowedHeader("*");
// configuration.addAllowedMethod("*");

// UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
// source.registerCorsConfiguration("/ws/**", configuration); // Apply CORS only to WebSocket endpoint
// return source;
// }
// }

/// Last working...

// package com.sportapi.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.messaging.simp.config.MessageBrokerRegistry;
// import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// @Configuration
// @EnableWebSocketMessageBroker
// public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//     @Override
//     public void registerStompEndpoints(StompEndpointRegistry registry) {
//         registry.addEndpoint("/ws")
//                 .setAllowedOrigins("*") // Allow requests from any origin
//                 .withSockJS(); // Enables SockJS fallback;
//     }

//     @Override
//     public void configureMessageBroker(MessageBrokerRegistry registry) {
//         registry.enableSimpleBroker("/topic"); // Enables a simple broker
//         registry.setApplicationDestinationPrefixes("/app"); // Prefix for client messages
//     }
// }


// package com.sportapi.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.messaging.simp.config.MessageBrokerRegistry;
// import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
// import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// @Configuration
// @EnableWebSocketMessageBroker
// public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//     @Bean
//     public ThreadPoolTaskScheduler taskScheduler() {
//         ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//         scheduler.setPoolSize(2);
//         scheduler.setThreadNamePrefix("websocket-heartbeat-thread-");
//         return scheduler;
//     }

//     @Override
//     public void registerStompEndpoints(StompEndpointRegistry registry) {
//         registry.addEndpoint("/ws")
//                 .setAllowedOriginPatterns("*")
//                 .withSockJS();
//     }

//     @Override
//     public void configureMessageBroker(MessageBrokerRegistry registry) {
//         registry.enableSimpleBroker("/topic")
//                .setTaskScheduler(taskScheduler())  // Use the task scheduler
//                .setHeartbeatValue(new long[]{10000, 10000});
//         registry.setApplicationDestinationPrefixes("/app");
//     }
// }
package org.resource.manager;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OpenAIChatController {

    private static final String CHAT_API_PREFIX = "/api/chat";

    private final ChatClient chatClient;

    @Autowired
    public OpenAIChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping({CHAT_API_PREFIX})
    public ResponseEntity<String> getChatResponse(@RequestParam("message") String message) {
        try {
            // Validate the input message to prevent potential security issues
            if (StringUtils.isEmpty(message)) {
                return ResponseEntity.badRequest().body("Message is required");
            }

            // Process the chat response using the ChatClient instance
            String response = chatClient.prompt(message).call().content();

            // Return the processed response as a successful HTTP response
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle any exceptions that occur during processing and log the error for debugging purposes
            System.out.println("Error processing chat request");
            // bad practice
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Internal Server Error");
        }
    }

    @GetMapping({CHAT_API_PREFIX + "/errors"})
    public ResponseEntity<String> getChatErrorResponse() {
        // Log any errors that occur during processing and return a 500 Internal Server Error response
        System.out.println("Error processing chat request");
        return ResponseEntity.internalServerError().body("Internal Server Error");
    }
}
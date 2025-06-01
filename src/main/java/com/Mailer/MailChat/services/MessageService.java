/***********************************************
 * 
 * The is a service class for messages
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file MessageService.java
 * @version 1.0
 * 
 * 
 */

package com.Mailer.MailChat.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import com.Mailer.MailChat.model.Message;

public class MessageService {
    private static final String EMAILS_PATH = "..\\..\\..\\resources\\constants\\dummyEmails.json";
    // private List<Message> messages = new ArrayList<>();
    private List<Message> testMessages = new ArrayList<>();

    public void sendMessage(Message msg) {
        msg.setTimestamp(LocalDateTime.now());
        msg.setFolder("Sent");
        testMessages.add(msg);
        saveToDisk(); // This is incomplete
    }

    public List<Message> getMessages(String folder){
        testMessages.add(new Message(
            "news@techworld.com",
            "you@example.com",
            "top 10 Programming Languages in 2025",
            "top 10 Programming Languages in 2025",
            LocalDateTime.of(2025,9,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Sent"
        ));
        
        testMessages.add(new Message(
            "support@someapp.io",
            "me@example.com",
            "Password Reset Request!",
            "We received a request to reset your password. Click the link below to proceed:\\n" + //
                                "\\n" + //
                                "https://someapp.io/reset?token=abc123",
            LocalDateTime.of(2025,05,30,9,15),
            "Important"
        ));
        
        testMessages.add(new Message(
            "scammer@example.com",
            "meagain@example.com",
            "Do you want to be a millionare!",
            "Hi Bob,\n\nYou've just been selected for a $.5,000,000 cash price. Do you want it or not?",
            LocalDateTime.of(2025,05,30,9,15),
            "Spam"
        ));
        
        testMessages.add(new Message(
            "sales@example.com",
            "bob@example.com",
            "New deal in town!",
            "Check out out brand new product. Save 30% and all your challenges will be gone.",
            LocalDateTime.of(2025,05,30,9,15),
            "Spams"
        ));
        
        testMessages.add(new Message(
            "joyce@example.com",
            "bob@example.com,heather@example.com",
            "Invitaion to end of year family party",
            "Hey love, hope to see you at the party.\nWe'll talk about the deal, remember? Bye!\n\nJoyce",
            LocalDateTime.of(2025,05,30,9,15),
            "Sent"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "newsletter@agilealec.academy",
            "bob@example.com",
            "Welcome to the team!",
            "Here’s what’s new this week:\\n" + //
                                "- Group Chat v2 launched\\n" + //
                                "- Agora Rooms now support video\\n" + //
                                "\\n" + //
                                "Visit the app for more updates.",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "newsletter@agilealec.academy",
            "bob@example.com",
            "Welcome to the team!",
            "Here’s what’s new this week:\\n" + //
                                "- Group Chat v2 launched\\n" + //
                                "- Agora Rooms now support video\\n" + //
                                "\\n" + //
                                "Visit the app for more updates.",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        testMessages.add(new Message(
            "alice@example.com",
            "bob@example.com",
            "Welcome to the team!",
            "Hi Bob,\n\nWelcome to the engineering team! Let me know if you need anything to get started.\n\nCheers,\nAlice",
            LocalDateTime.of(2025,05,30,9,15),
            "Inbox"
        ));
        
        // return messages.stream().filter(m->m.getFolder().equals(folder)).collect(Collectors.toList());
        return testMessages;
    }

    public List<Message> getDummyMessages() {
        try (InputStream is = getClass().getResourceAsStream(EMAILS_PATH)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, new TypeReference<List<Message>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // empty list fallback
        }
    }

    private void saveToDisk() {
        // NOTE: saveToDisk() to be implemented with database
        System.out.println("Save to disk triggered, yet to be implemented!");
    }

    @SuppressWarnings("unused")
    private void loadFromDisk() {
        // NOTE: loadFromDisk() to be implemented with database
    }
}

/*************************************************
 * This is a message controller method
 * 
 * @file MessageController.java
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.Mailer.MailChat.components.Layout.*;
import com.Mailer.MailChat.model.Message;

public class MessageController {
    private List<Message> allMessages;
    private MessageListPanel listPanel;
    private MessageViewPanel viewPanel;

    public MessageController(List<Message> messages, MessageListPanel listPanel, MessageViewPanel viewPanel) {
        this.allMessages = messages;
        this.listPanel = listPanel;
        this.viewPanel = viewPanel;
    }

    public void filterMessages(String category) {
        List<Message> filtered = allMessages.stream()
                .filter(msg -> msg.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        listPanel.displayMessages(filtered);
    }

    public void showMessage(Message message) {
        viewPanel.displayMessage(message);
    }

    public void setAllMessages(List<Message> messages) {
        this.allMessages = messages;
    }

    public void composeMessage() {
        new ComposePanel().setVisible(true);
    }
}

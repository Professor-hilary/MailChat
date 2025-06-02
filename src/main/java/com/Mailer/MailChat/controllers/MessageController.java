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

import javax.swing.JLabel;

import com.Mailer.MailChat.components.Layout.*;
import com.Mailer.MailChat.model.MessageModal;
import com.Mailer.MailChat.services.MailService;

public class MessageController {
    private List<MessageModal> allMessages;
    private List<MessageModal> fetchedMails;
    private MessageListPanel listPanel;
    private MessageViewPanel viewPanel;
    private MailService mailService;
    // private MailFetcher fetcher = new MailFetcher();

    public MessageController(/* List<MessageModal> messages, */ MessageListPanel listPanel,
            MessageViewPanel viewPanel) {
        // this.allMessages = messages;
        this.listPanel = listPanel;
        this.viewPanel = viewPanel;
        this.mailService = new MailService();
        fetchInbox("hilaryokuonzi9@gmail.com", "ehzp qwtk sqvp xlqa", "imap.gmail.com", 993);
    }

    public void filterMessages(String category) {
        List<MessageModal> filtered = allMessages.stream()
                .filter(msg -> msg.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        listPanel.displayMessages(filtered, category);
    }

    public void showMessage(MessageModal message) {
        viewPanel.displayMessage(message);
    }

    public void setAllMessages(List<MessageModal> messages) {
        this.allMessages = messages;
    }

    public void composeMessage() {
        viewPanel.add(new JLabel("Hello Friday"));
        new ComposePanel().setVisible(true);
    }

    public void handleSend(String to, String subject, String content, String category) {
        MessageModal mail = new MessageModal("hilaryokuonzi9@gmail.com", to, subject, content, category);

        boolean success = mailService.send(mail);
        if (success) {
            System.out.println("Email sent!");
        } else {
            System.out.println("Failed to send email.");
        }
    }

    public void fetchInbox(String email, String password, String host, int port) {
        // fetchedMails = mailService.fetchInbox(email, password, host, port);
        fetchedMails = mailService.fetchInboxWithRetry(host,email, password, port, 8);

        List<MessageModal> messages = fetchedMails.stream()
                .map(mail -> new MessageModal(
                        mail.getSender(),
                        mail.getReceipient(),
                        mail.getSubject(),
                        mail.getBody(),
                        "INBOX"))
                .collect(Collectors.toList());

        this.setAllMessages(messages);
        listPanel.displayMessages(messages, "INBOX");
    }
}

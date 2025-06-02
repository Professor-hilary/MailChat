/***********************************************
 * 
 * The is a message model. Containes message
 * model methods and attributes for representing
 * message objects
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file Message.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.model;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MessageModal {
    @SuppressWarnings("unused")
    private String id;
    private String sender;
    private List<String> receipients;
    private String receipient;
    private String subject;
    private boolean isRead;
    private String body;
    private LocalDateTime timestamp;
    private List<File> attachments;
    private String errorMsg = "undefined";
    private String folder; // inbox, sent, draft, trash

    public MessageModal(String sender, String receipients, String subject, String body, LocalDateTime timestamp,
            String folder) {
        this.sender = sender;
        this.receipients = Arrays.asList(receipients.split(","));
        this.subject = subject;
        this.body = body;
        this.timestamp = timestamp;
        this.folder = folder;
    }

    public MessageModal(String from, String to, String subject, String body, String category) {
        this.sender = from;
        this.receipient = to;
        this.subject = subject;
        this.body = body;
        this.folder = category;
    }

    public MessageModal(String from, String to, String subject, String body) {
        this.sender = from;
        this.receipient = to;
        this.subject = subject;
        this.body = body;
    }

    public MessageModal() {
        // This is a default empty constructor
    }

    // Setter methods for each Message Modal attribute
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void setReceipients(String receipients) {
        this.receipients = Arrays.asList(receipients.split(","));
    }

    public void setReceipient(String receipient) {
        this.receipient = receipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setReadStatus(boolean status) {
        this.isRead = status;
    }

    public void setAttachments(List<File> files) {
        attachments = files;
    }

    // Getter methods for each Message Modal attribute
    public String getFolder() {
        try {
            return folder;
        } catch (Exception e) {
            return this.errorMsg;
        }
    }

    public String getBody() {
        try {
            return body;
        } catch (Exception e) {
            return this.errorMsg;
        }
    }

    public String getSubject() {
        try {
            return subject;
        } catch (Exception e) {
            return this.errorMsg;
        }
    }

    public String getCategory() {
        try {
            return folder;
        } catch (Exception e) {
            return this.errorMsg;
        }
    }

    public String getSender() {
        try {
            return sender;
        } catch (Exception e) {
            return this.errorMsg;
        }
    }

    public LocalDateTime getTimestamp() {
        try {
            return timestamp;
        } catch (Exception e) {
            return LocalDateTime.now();
        }
    }

    public List<String> getReceipients() {
        try {
            return receipients;
        } catch (Exception e) {
            return null;
        }
    }

    public String getReceipient() {
        try {
            return receipient;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean getReadStatus() {
        try {
            return isRead;
        } catch (Exception e) {
            return false;
        }
    }

    public List<File> getAttachments() {
        try {
            return attachments;
        } catch (Exception e) {
            return null;
        }
    }
}

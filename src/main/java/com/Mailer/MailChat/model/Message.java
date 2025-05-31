package com.Mailer.MailChat.model;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private String id;
    private String sender;
    private MessageStatus status;
    private String threadId;
    private List <String>receipients;
    private String subject;
    private String body;
    private LocalDateTime timestamp;
    private List<File>attachments;
    private String folder; // inbox, sent, draft, trash

    public void setTimestamp(LocalDateTime now) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTimestamp'");
    }

    public void setFolder(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFolder'");
    }

    public Object getFolder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFolder'");
    }

    public void setRecipient(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRecipient'");
    }

    public void setSubject(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSubject'");
    }

    public void setBody(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBody'");
    }
}

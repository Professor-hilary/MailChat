package com.Mailer.MailChat.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.Mailer.MailChat.model.Message;

public class MessageService {
    private List<Message> messages = new ArrayList<>();

    public void sendMessage(Message msg){
        msg.setTimestamp(LocalDateTime.now());
        msg.setFolder("sent");
        messages.add(msg);
        saveToDisk();
    }

    private List<Message> getMessages(String folder){
        return messages.stream().filter(m->m.getFolder().equals(folder)).collect(Collectors.toList());
    }

    private void saveToDisk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveToDisk'");
    }

    private void loadFromDisk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadFromDisk'");
    }
}

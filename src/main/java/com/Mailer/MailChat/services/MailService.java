package com.Mailer.MailChat.services;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.Mailer.MailChat.model.MessageModal;

public class MailService {

    public boolean send(com.Mailer.MailChat.model.MessageModal mail) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("hilaryokuonzi9@gmail.com", "jesus.No1");
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail.getSender()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getReceipient()));
            message.setSubject(mail.getSubject());
            message.setText(mail.getBody());

            Transport.send(message);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MessageModal> fetchInbox(String email, String password, String host, int port) {
        List<MessageModal> mails = new ArrayList<>();
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            props.put("mail.imap.host", host);
            props.put("mail.imap.port", String.valueOf(port));
            props.put("mail.imap.ssl.enable", "true");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(host, email, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();

            for (int i = messages.length - 1; i >= 0 && i >= messages.length - 10; i--) { // fetch latest 10
                Message msg = messages[i];

                String from = msg.getFrom()[0].toString();
                String subject = msg.getSubject();
                String content = getTextFromMessage(msg);

                MessageModal mail = new MessageModal(from, email, subject, content);
                mails.add(mail);
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mails;
    }

    public List<MessageModal> fetchInboxWithRetry(String host, String user, String password, int port, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                System.out.println("Attempt " + (attempts + 1) + " to connect to " + host);
                return fetchInbox(user, password, host, port); // Your actual inbox fetch logic
            } catch (Exception e) {
                System.err.println("Failed attempt " + (attempts + 1) + ": " + e.getMessage());
                
                if (e.getCause() instanceof UnknownHostException) {
                    System.err.println("DNS error. Host may be unreachable.");
                }
    
                attempts++;
                try {
                    Thread.sleep(2000 * attempts); // Exponential backoff: 2s, 4s, 6s...
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Restore interrupt flag
                    break;
                }
            }
        }
        System.err.println("All retry attempts failed.");
        return Collections.emptyList(); // Return an empty list or null depending on your app flow
    }

    private String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            return getTextFromMimeMultipart(mimeMultipart);
        }
        return "";
    }

    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart part = mimeMultipart.getBodyPart(i);
            if (part.isMimeType("text/plain")) {
                result.append(part.getContent());
            }
        }

        return result.toString();
    }
}
package com.Mailer.MailChat.components.Layout;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MessageViewPanel extends JPanel {
    private JTextArea messagePreview;

    public MessageViewPanel() {
        setLayout(new BorderLayout());
        messagePreview = new JTextArea("Select a message to view...");
        messagePreview.setLineWrap(true);
        messagePreview.setWrapStyleWord(true);
        messagePreview.setEditable(false);

        add(new JScrollPane(messagePreview), BorderLayout.CENTER);
    }

    public void displayMessage(String messageTitle) {
        messagePreview.setText("Message: " + messageTitle + "\n\n[Body goes here]");
    }
}

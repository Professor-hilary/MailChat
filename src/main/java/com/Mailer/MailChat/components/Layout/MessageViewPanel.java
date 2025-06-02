/***********************************************
 * 
 * The is a messages view panel UI layout
 * class component for showing a selected
 * messages from the messages panel list
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file MessageViewPanel.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.components.Layout;

import javax.swing.*;

import com.Mailer.MailChat.model.MessageModal;

import java.awt.*;

public class MessageViewPanel extends JPanel {
    private JLabel subjectLabel;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel timestampLabel;
    private JTextArea bodyArea;

    public MessageViewPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setPreferredSize(new Dimension(0, 230));

        subjectLabel = new JLabel("Subject");
        subjectLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        fromLabel = new JLabel("From: ");
        toLabel = new JLabel("To: ");
        timestampLabel = new JLabel("Date: ");

        Font metaFont = new Font("Segoe UI", Font.PLAIN, 12);
        fromLabel.setFont(metaFont);
        toLabel.setFont(metaFont);
        timestampLabel.setFont(metaFont);

        bodyArea = new JTextArea(1, 1);
        bodyArea.setFont(new Font("Serif", Font.PLAIN, 14));
        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);
        bodyArea.setEditable(false);

        bodyArea.setBorder(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setOpaque(false);
        headerPanel.add(subjectLabel);
        headerPanel.add(Box.createVerticalStrut(8));
        headerPanel.add(fromLabel);
        headerPanel.add(toLabel);
        headerPanel.add(timestampLabel);

        JScrollPane bodyScroll = new JScrollPane(bodyArea);
        bodyScroll.setBorder(null);

        add(headerPanel, BorderLayout.NORTH);
        add(bodyScroll, BorderLayout.CENTER);
    }

    public void displayMessage(MessageModal message) {
        subjectLabel.setText(message.getSubject());
        fromLabel.setText("From: " + message.getSender());
        toLabel.setText("To: " + message.getReceipients());
        timestampLabel.setText("Date: " + message.getTimestamp());
        bodyArea.setText(message.getBody());
    }
}

package com.Mailer.MailChat.components.Layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.Mailer.MailChat.model.Message;
import com.Mailer.MailChat.services.MessageService;

public class ComposePanel extends JPanel {
    public ComposePanel() {
        setLayout(new BorderLayout());

        JTextField toField = new JTextField();
        JTextField subjectField = new JTextField();
        JTextField messageField = new JTextField();

        JButton sendBtn = new JButton("Send");
        sendBtn.addActionListener(e -> {
            Message msg = new Message();
            msg.setRecipient(toField.getText());
            msg.setSubject(subjectField.getText());
            msg.setBody(messageField.getText());
            new MessageService().sendMessage(msg);
            JOptionPane.showMessageDialog(this, "Message sent.");
        });

        JPanel top = new JPanel(new GridLayout(2, 2));
        top.add(new JLabel("To:"));
        top.add(toField);
        top.add(new JLabel("Subject:"));
        top.add(subjectField);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(messageField),BorderLayout.CENTER);
        add(sendBtn, BorderLayout.SOUTH);
    }
}

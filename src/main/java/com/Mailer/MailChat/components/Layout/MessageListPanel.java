package com.Mailer.MailChat.components.Layout;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MessageListPanel extends JPanel {
    private JList<String>messageList;

    public MessageListPanel(){
        setLayout(new BorderLayout());
        DefaultListModel<String>model = new DefaultListModel<>();
        model.addElement("Project Update - Q3");
        model.addElement("Invoice #33421");
        model.addElement("Weekly Team Sync");

        messageList = new JList<>(model);
        add(new JScrollPane(messageList),BorderLayout.CENTER);
    }

    public JList<String> getMessageList(){
        return messageList;
    }
}

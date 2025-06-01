/***********************************************
 * 
 * The is a layout component class compose 
 * message UI
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file ComposePanel.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.components.Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.Mailer.MailChat.model.Message;
import com.Mailer.MailChat.services.MessageService;

public class ComposePanel extends JDialog {
    @SuppressWarnings("unused")
    public ComposePanel() {
        setTitle("Compose Message");
        setSize(600, 500);
        setModal(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Main modal panel where everything goes
        JPanel fieldsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Message fields here
        JTextField toTextField = new JTextField();
        JTextField fromTextField = new JTextField("prof_einstein@example.com");
        JTextField subjecTextField = new JTextField();
        JTextField attachmentsTextField = new JTextField();
        JEditorPane editorPane = new JEditorPane();

        JButton attachButton = new JButton("Attach Files");
        attachButton.addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setMultiSelectionEnabled(true);
            int option = fileChooser.showOpenDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();

                // Process the selected files
                for (File file : files) {
                    System.out.println("Selected files: " + file.getAbsolutePath());

                    // Add file to the message's attachment
                    attachmentsTextField.setText(
                            attachmentsTextField.getText() + file.getAbsolutePath() + ",");
                }
            }
        });

        fieldsPanel.add(new JLabel("From: "));
        fieldsPanel.add(fromTextField);
        fieldsPanel.add(new JLabel("To: "));
        fieldsPanel.add(toTextField);
        fieldsPanel.add(new JLabel("Subject: "));
        fieldsPanel.add(subjecTextField);
        fieldsPanel.add(attachButton);
        fieldsPanel.add(attachmentsTextField);

        editorPane.setContentType("text/html");
        editorPane.setText("<p>Hello,</p><p></p><p>Regards,</p>");
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JButton sendButton = new JButton("Send");
        JButton cancelButton = new JButton("Cancel");
        sendButton.setBackground(new Color(0, 123, 255));
        sendButton.setPreferredSize(new Dimension(0, 30));
        cancelButton.setBackground(new Color(255, 13, 0));
        cancelButton.setPreferredSize(new Dimension(0, 30));

        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);

        sendButton.addActionListener(event -> {
            // Simulate sending
            Message msg = new Message();
            msg.setReceipients(toTextField.getText());
            msg.setSubject(subjecTextField.getText());
            msg.setBody(editorPane.getText());
            new MessageService().sendMessage(msg);

            /*
             * new Message(fromTextField.getText(), toTextField.getText(),
             * subjecTextField.getText(), editorPane.getText(), LocalDateTime.now(),
             * "Sent");
             */

            JOptionPane.showMessageDialog(this, "Message sent.");
            dispose();
        });

        cancelButton.addActionListener((event) -> {
            dispose();
            return;
        });

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.add(sendButton);
        buttonsPanel.add(cancelButton);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        add(fieldsPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}

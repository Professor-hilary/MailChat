/***********************************************
 * 
 * The is a sidebar view panel UI layout
 * class component for showing vertically
 * aligned utilities to navigate different
 * message types and triggers messages list
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file SidebarPanel.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.components.Layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.Mailer.MailChat.controllers.MessageController;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;

public class SidebarPanel extends JPanel {
    @SuppressWarnings("unused")
    public SidebarPanel(MessageController controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(230, 230, 230, 23));
        setPreferredSize(new Dimension(200, 0));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Imitate a button click to show inboxes in messages list panel
        // SwingUtilities.invokeLater(() -> controller.filterMessages("Inbox"));

        // Buttons for message categories
        addCategoryButton("Inbox", "inbox-unread", controller::filterMessages, controller);
        addCategoryButton("Sent", "message", controller::filterMessages, controller);
        addCategoryButton("Drafts", "notepad", controller::filterMessages, controller);
        addCategoryButton("Important", "cloud-saved", controller::filterMessages, controller);
        addCategoryButton("Unread", "message-2", controller::filterMessages, controller);
        addCategoryButton("Spam", "garbage", controller::filterMessages, controller);
        addCategoryButton("Trash", "trash-bin", controller::filterMessages, controller);
        add(Box.createVerticalStrut(30));

        JButton composeButton = new JButton("Compose");
        composeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        composeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        composeButton.setBackground(new Color(51, 153, 255));
        composeButton.setForeground(Color.WHITE);
        composeButton.setFocusPainted(false);
        composeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        composeButton.setMaximumSize(new Dimension(160, 40));
        composeButton.setIcon(new FlatSVGIcon("icons/compose.svg", 16, 16));
        composeButton.setIconTextGap(10);
        composeButton.setHorizontalAlignment(SwingConstants.LEFT);
        composeButton.addActionListener(e -> controller.composeMessage());

        add(composeButton);
    }

    @SuppressWarnings("unused")
    private void addCategoryButton(String title, String icon, java.util.function.Consumer<String> onClick,
            MessageController controller) {
        JButton button = new JButton(title);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 40));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        button.setIcon(new FlatSVGIcon("icons/" + icon + ".svg", 16, 16));
        button.setBackground(new Color(90, 90, 90));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(10);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        if (button.getText() == "Inbox") {
            // Inbox receiving component
            button.addActionListener(e -> {
                controller.fetchInbox(
                        "hilaryokuonzi9@gmail.com", "ehzp qwtk sqvp xlqa", "imap.gmail.com", 993);
            });
        }
        button.addActionListener(e -> onClick.accept(title));
        add(button);
        add(Box.createVerticalStrut(10));
    }
}

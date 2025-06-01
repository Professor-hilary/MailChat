/***********************************************
 * 
 * The is a messages list panel
 * class component for showing a list of messages
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file MessageListPanel.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.components.Layout;

import javax.swing.*;

import com.Mailer.MailChat.model.Message;

import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

public class MessageListPanel extends JPanel {
    private JPanel listContainer;
    private Consumer<Message> messageClickListener;

    public void setMessageClickListener(Consumer<Message> listener) {
        this.messageClickListener = listener;
    }

    public MessageListPanel() {
        setLayout(new BorderLayout());

        listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(listContainer);
        // scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayMessages(List<Message> messages) {
        listContainer.removeAll();

        for (Message msg : messages) {
            JPanel card = createMessageCard(msg);
            listContainer.add(card);
            listContainer.add(Box.createVerticalStrut(8));
        }

        listContainer.revalidate();
        listContainer.repaint();
    }

    private JPanel createMessageCard(Message message) {
        String body = message.getBody();
        body = (body == null) ? "" : body;

        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // <<< Don't skip this.
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.18f));
                g2d.setColor(new Color(245, 245, 245));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
                super.paintComponent(g); // Optional depending on other drawing
            }
        };
        panel.setBackground(new Color(245, 245, 245, 45));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel subject = new JLabel(message.getSubject());
        subject.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel sender = new JLabel(message.getSender());
        sender.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        // sender.setForeground(Color.GRAY);

        JLabel preview = new JLabel("<html><div style='width: 300px;'>"
                + message.getBody().substring(0, Math.min(80, message.getBody().length())) + "...</div></html>");
        preview.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        // preview.setForeground(Color.DARK_GRAY);

        JLabel time = new JLabel(message.getTimestamp().toString());
        time.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        // time.setForeground(Color.GRAY);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.add(subject);
        textPanel.add(Box.createVerticalStrut(3));
        textPanel.add(sender);
        textPanel.add(preview);

        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(time, BorderLayout.EAST);

        // Add mouse hover effects
        Color baseColor = new Color(245, 245, 245);
        Color hoverColor = new Color(230, 240, 250);

        panel.setBackground(baseColor);

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(baseColor);
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (messageClickListener != null) {
                    messageClickListener.accept(message);
                }
            }
        });

        panel.setOpaque(false); // IMPORTANT!

        return panel;
    }
}

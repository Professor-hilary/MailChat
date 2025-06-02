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
import javax.swing.border.*;
import java.awt.*;
import java.util.List;
import java.time.LocalDateTime;
import java.util.function.Consumer;

import com.Mailer.MailChat.model.MessageModal;

public class MessageListPanel extends JPanel {
    private final JPanel listContainer;
    private final JLabel titleLabel;
    private Consumer<MessageModal> messageClickListener;

    public void setMessageClickListener(Consumer<MessageModal> listener) {
        this.messageClickListener = listener;
    }

    public MessageListPanel() {
        setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(true);
        titlePanel.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, new Color(120, 120, 120)),
                new EmptyBorder(0, 15, 0, 15)));

        titleLabel = new JLabel("Messages");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titlePanel.add(titleLabel);

        // Scrollable Message List Container
        listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(listContainer);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        add(titlePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayMessages(List<MessageModal> messages, String category) {
        titleLabel.setText(category);
        listContainer.removeAll();
        listContainer.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
        
        if (messages.isEmpty()) {
            JLabel emptyLabel = new JLabel("No messages found.");
            emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            emptyLabel.setForeground(Color.GRAY);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            listContainer.add(Box.createVerticalStrut(40));
            listContainer.add(emptyLabel);
        } else {
            for (MessageModal msg : messages) {
                JPanel card = createMessageCard(msg);
                listContainer.add(Box.createVerticalStrut(10));
                listContainer.add(card);
            }
        }

        listContainer.revalidate();
        listContainer.repaint();
    }

    private JPanel createMessageCard(MessageModal message) {
        String body = (message.getBody() != null) ? message.getBody() : "";

        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.16f));
                g2d.setColor(new Color(200, 200, 200, 80)); // Neutral alpha fill
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                g2d.dispose();
            }
        };

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.setOpaque(false); // Allow alpha painting
        
        // Message details subject
        JLabel subject = new JLabel(message.getSubject());
        subject.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Message details sender
        JLabel sender = new JLabel(message.getSender());
        sender.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        // Message details body
        JLabel preview = new JLabel("<html><div style='width: 300px;'>"
        + body.substring(0, Math.min(80, body.length())) + "...</div></html>");
        preview.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        LocalDateTime timestamp = message.getTimestamp();
        String timeText = (timestamp != null) ? timestamp.toString() : "Unknown Time";
        
        // Message details date and time
        JLabel time = new JLabel(timeText);
        time.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        
        // Layout for text
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.add(subject);
        textPanel.add(Box.createVerticalStrut(3));
        textPanel.add(sender);
        textPanel.add(preview);
        
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(time, BorderLayout.EAST);

        // Hover effect
        Color hoverColor = new Color(255, 255, 255, 40); // translucent highlight

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(hoverColor);
                panel.repaint();
                System.out.println("Hovered Entered");
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(null);
                panel.repaint();
                System.out.println("Hovered Exited");
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (messageClickListener != null) {
                    messageClickListener.accept(message);
                    System.out.println("Card clicked");
                }
            }
        });

        return panel;
    }

    // Optional: Reusable rounded border for theme support
    class RoundedBorder implements Border {
        private int radius;
        private Color color;

        RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
        }

        public boolean isBorderOpaque() {
            return false;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

}

package com.Mailer.MailChat.components.Layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SidebarPanel extends JPanel {
    private final Map<String, JButton> buttonMap = new LinkedHashMap<>();
    private String selectedKey = "Inbox";

    public SidebarPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // setBackground(new Color(250, 250, 250));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] items = { "Inbox", "Sent", "Drafts", "Trash", "Compose" };
        for (String label : items) {
            JButton button = createSidebarButton(label);
            buttonMap.put(label, button);
            add(button);
            add(Box.createVerticalStrut(8));
        }

        highlightSelected("Inbox");
    }

    private void highlightSelected(String key) {
        for (Map.Entry<String, JButton> entry : buttonMap.entrySet()) {
            JButton btn = entry.getValue();
            if (entry.getKey().equals(key)) {
                btn.setBackground(new Color(220, 235, 250)); // light blue highlight
            } else {
                btn.setBackground(new Color(250, 250, 250)); // neutral
            }
        }

        selectedKey = key;
    }

    @SuppressWarnings("unused")
    private JButton createSidebarButton(String label) {
        JButton button = new JButton(label);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(250, 250, 250));
        // button.setIcon(new FlatSVGIcon());
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(180, 40));
        button.setMaximumSize(new Dimension(180, 40));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        button.addActionListener(e -> {
            highlightSelected(label);
            System.out.println("Clicked: " + label); // logic can be routed from here
        });

        return button;
    }

    public String getSelectedKey(){
        return selectedKey;
    }
}

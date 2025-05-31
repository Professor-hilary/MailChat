package com.Mailer.MailChat.apps.about;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class About extends JPanel {
    public JPanel about() {
        // Set up panel two and add to tabbed panel
        JLabel aboutJLabel = new JLabel("About", SwingConstants.RIGHT);
        JPanel aboutPanel = new JPanel();
        aboutPanel.add(aboutJLabel);

        return aboutPanel;
    }
    
}
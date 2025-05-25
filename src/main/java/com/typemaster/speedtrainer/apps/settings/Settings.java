package com.typemaster.speedtrainer.apps.settings;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Settings extends JPanel{
    public JPanel settings(){
        // Set up panel two and add to tabbed panel
        JLabel settingsJLabel = new JLabel("Settings", SwingConstants.CENTER);
        JPanel settingsJPanel = new JPanel();
        settingsJPanel.add(settingsJLabel);

        return settingsJPanel;
    }
}

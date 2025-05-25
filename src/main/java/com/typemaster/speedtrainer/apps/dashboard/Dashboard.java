package com.typemaster.speedtrainer.apps.dashboard;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dashboard extends JPanel{
    public JPanel dashboard() {
        JLabel dashboardLabel = new JLabel("Dashboard", SwingConstants.CENTER);
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout()); // Layout for positioning items
        dashboardPanel.add(new JButton("North"), BorderLayout.NORTH);
        dashboardPanel.add(new JButton("South"), BorderLayout.SOUTH);
        dashboardPanel.add(dashboardLabel, BorderLayout.CENTER);

        return dashboardPanel;
    }
}
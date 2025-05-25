package com.typemaster.speedtrainer;

import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TabbedFrame extends JFrame {
    public TabbedFrame() throws IOException {
        super("Type Master");

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT); // Create tabbed pane

        // Set up panel one and add to tabbed panel
        JLabel label1 = new JLabel("Panel One", SwingConstants.CENTER);
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        tabbedPane.addTab("Tab One", null, panel1, "First Panel");

        // Set up panel two and add to tabbed panel
        JLabel label2 = new JLabel("Panel Two", SwingConstants.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.YELLOW);
        panel1.add(label2);
        tabbedPane.addTab("Tab Two", null, panel2, "Second Panel");

        // Set up panel one and add to tabbed panel
        JLabel label3 = new JLabel("Panel Two", SwingConstants.CENTER);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout()); // Layout for positioning items
        panel3.add(new JButton("North"), BorderLayout.NORTH);
        panel3.add(new JButton("West"), BorderLayout.WEST);
        panel3.add(new JButton("East"), BorderLayout.EAST);
        panel3.add(new JButton("South"), BorderLayout.SOUTH);
        panel3.add(label3, BorderLayout.CENTER);
        panel3.setBackground(Color.LIGHT_GRAY);
        tabbedPane.addTab("Tab Three", null, panel3, "Third Panel");

        add(tabbedPane); // Add JTabbedPane to frame
    } // end TabbedFrame constructor
} // end class TabbedFrame
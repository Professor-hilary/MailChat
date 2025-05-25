package com.typemaster.speedtrainer.components.Layout;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.formdev.flatlaf.ui.FlatTabbedPaneUI;
import com.typemaster.speedtrainer.apps.about.About;
import com.typemaster.speedtrainer.apps.dashboard.Dashboard;
import com.typemaster.speedtrainer.apps.leaderboard.Leaderboard;
import com.typemaster.speedtrainer.apps.practice.Practice;
import com.typemaster.speedtrainer.apps.settings.Settings;

public class Navbar extends JFrame {
    public Navbar() throws IOException {
        super("Type Master");

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT); // Create tabbed pane
        tabbedPane.setUI(new FlatTabbedPaneUI());
        tabbedPane.setAlignmentX(LEFT_ALIGNMENT);

        // Set panels for the panel layout
        tabbedPane.addTab("Dashboard", null, new Dashboard().dashboard(), "Home and progress panel");
        tabbedPane.addTab("Practice", null, new Practice().practice(), "Practice and exercise Panel");
        tabbedPane.addTab("Leaderboard", null, new Leaderboard().leaderboard(), "Leaderboard for best performers");
        tabbedPane.addTab("Settings", null, new Settings().settings(), "Themes and Settings panel");
        tabbedPane.addTab("About", null, new About().about(), "About, documentation and contributors");
        
        add(tabbedPane); // Add JTabbedPane to frame

    } // end TabbedFrame constructor
} // end class TabbedFrame
package com.typemaster.speedtrainer.apps.leaderboard;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Leaderboard extends JPanel {
    public JPanel leaderboard(){
        // Set up panel two and add to tabbed panel
        JLabel leaderboardLabel = new JLabel("Leaderboard", SwingConstants.CENTER);
        JPanel leaderboardPanel = new JPanel();
        leaderboardPanel.add(leaderboardLabel);

        return leaderboardPanel;
    }
}

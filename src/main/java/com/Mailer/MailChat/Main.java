package com.Mailer.MailChat;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.Mailer.MailChat.components.MailUI;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // Options: "Metal", "Nimbus", "Motif", "Windows", "GTK+"
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            MailUI tabbedFrame = new MailUI();
            tabbedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tabbedFrame.setSize(800, 500);
            tabbedFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            device.setFullScreenWindow(tabbedFrame);

            tabbedFrame.setVisible(true);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(
                    null,
                    "An error occured: " + err.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Optional: Exit program after error
        }
    } // end main
} // end class Main
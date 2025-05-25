package com.typemaster.speedtrainer;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.typemaster.speedtrainer.components.Layout.Navbar;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // Options: "Metal", "Nimbus", "Motif", "Windows", "GTK+"
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            // UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel");
            Navbar tabbedFrame = new Navbar();
            tabbedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tabbedFrame.setSize(800, 500);
            tabbedFrame.setVisible(true);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(
                    null,
                    "An error occured: " + err.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            // System.exit(1); // Optional: Exit program after error
        }
    } // end main
} // end class Main
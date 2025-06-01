package com.Mailer.MailChat.components.Layout;

import com.formdev.flatlaf.util.UIScale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class MyTitlePane extends JPanel {
    private final JFrame frame;
    private Point initialClick;

    public MyTitlePane(JFrame frame, String titleText, Icon appIcon) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, UIScale.scale(32)));
        setBackground(UIManager.getColor("TitlePane.background"));

        
        // Left: SVG app icon + Title
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        leftPanel.setOpaque(false);

        if (appIcon != null) {
            JLabel iconLabel = new JLabel(appIcon);
            leftPanel.add(iconLabel);
        }

        JLabel titleLabel = new JLabel(titleText);
        titleLabel.setForeground(UIManager.getColor("TitlePane.foreground"));
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 14f));
        leftPanel.add(titleLabel);
        
        leftPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        add(leftPanel, BorderLayout.WEST);
        
        // Right: Action buttons
        JPanel actionButtons = createControlButtons();
        actionButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        add(actionButtons, BorderLayout.EAST);

        enableWindowDrag(this);
    }

    private JPanel createControlButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 6));
        panel.setOpaque(false);

        JButton minimizeBtn = createSymbolButton("–", () -> frame.setState(Frame.ICONIFIED));
        JButton maximizeBtn = createSymbolButton("⬜", () -> {
            int state = frame.getExtendedState();
            if ((state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH)
                frame.setExtendedState(Frame.NORMAL);
            else
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        });
        JButton closeBtn = createSymbolButton("×", () -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
        
        panel.add(minimizeBtn);
        panel.add(maximizeBtn);
        panel.add(closeBtn);

        return panel;
    }

    @SuppressWarnings("unused")
    private JButton createSymbolButton(String symbol, Runnable action) {
        JButton button = new JButton(symbol);
        button.setPreferredSize(new Dimension(30, 20));
        button.setFont(new Font("Dialog", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(60, 60, 60));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusPainted(false);

        button.addActionListener(e -> action.run());

        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(symbol=="×"){
                    button.setBackground(Color.RED);
                }else{
                    button.setBackground(new Color(90, 90, 90));
                }
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(60, 60, 60));
                button.setCursor(Cursor.getDefaultCursor());
            }
        });

        return button;
    }

    private void enableWindowDrag(JComponent comp) {
        comp.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        comp.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (initialClick == null) return;
                int thisX = frame.getLocation().x;
                int thisY = frame.getLocation().y;

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                frame.setLocation(X, Y);
            }
        });
    }
}

package com.Mailer.MailChat.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import com.Mailer.MailChat.components.Layout.MessageListPanel;
import com.Mailer.MailChat.components.Layout.MessageViewPanel;
import com.Mailer.MailChat.components.Layout.SidebarPanel;
import com.formdev.flatlaf.ui.FlatTitlePane;

public class MailUI extends JFrame {
    public MailUI() throws IOException {
        super("Mailer");

        setLayout(new BorderLayout());

        // Title Pane for title and close button
        FlatTitlePane titlePane = new FlatTitlePane(rootPane);
        titlePane.setPreferredSize(new Dimension(0, 40));
        add(titlePane, BorderLayout.NORTH);

        // Three sections
        SidebarPanel sidebar = new SidebarPanel();
        MessageListPanel messageListPanel = new MessageListPanel();
        MessageViewPanel messageViewPanel = new MessageViewPanel();

        // Write message selection to preview
        messageListPanel.getMessageList().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = messageListPanel.getMessageList().getSelectedValue();
                if (selected != null) {
                    messageViewPanel.displayMessage(selected);
                }
            }
        });

        // Splits
        JSplitPane verticalSplitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, messageListPanel, messageViewPanel);
        verticalSplitPane.setDividerLocation(300);

        JSplitPane horizontalSplitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, sidebar, verticalSplitPane);
        horizontalSplitPane.setDividerLocation(200);

        add(horizontalSplitPane); // Add JTabbedPane to frame
    } // end TabbedFrame constructor
} // end class TabbedFrame

/***********************************************
 * 
 * The entry point for the project second to
 * Main.java. This file loads the main frame
 * and all major UI components into place -
 * i.e. sidepanel, list panel and view panel
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file MailUI.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.Mailer.MailChat.components.Layout.MessageListPanel;
import com.Mailer.MailChat.components.Layout.MessageViewPanel;
import com.Mailer.MailChat.components.Layout.RibbonPanel;
import com.Mailer.MailChat.components.Layout.SidebarPanel;
import com.Mailer.MailChat.controllers.MessageController;
import com.Mailer.MailChat.services.MessageService;
import com.formdev.flatlaf.ui.FlatTitlePane;

public class MailUI extends JFrame {
    public MailUI() throws IOException {
        super("Mailer");

        setLayout(new BorderLayout());

        JPanel headerSectionPanel = new JPanel(new BorderLayout());
        
        // Title Pane for title and close button
        FlatTitlePane titlePane = new FlatTitlePane(rootPane);
        titlePane.setPreferredSize(new Dimension(0, 40));
        headerSectionPanel.add(titlePane, BorderLayout.NORTH);
        headerSectionPanel.add(new RibbonPanel(), BorderLayout.CENTER);

        add(headerSectionPanel, BorderLayout.NORTH);

        // Sections controlled by sidebar
        MessageListPanel messageListPanel = new MessageListPanel();
        MessageViewPanel messageViewPanel = new MessageViewPanel();
        
        // Message Controller contains methods to assist sidebar panel actions
        MessageController controller = new MessageController(new MessageService().getMessages("Inbox"), messageListPanel, messageViewPanel);
        SidebarPanel sidebar = new SidebarPanel(controller);

        messageListPanel.setMessageClickListener(controller::showMessage);
        
        // Splits for side panel, message view and list view
        JSplitPane verticalSplitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, messageListPanel, messageViewPanel);
        verticalSplitPane.setDividerLocation(700);

        JSplitPane horizontalSplitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, sidebar, verticalSplitPane);
        horizontalSplitPane.setDividerLocation(200);

        add(horizontalSplitPane); // Add JTabbedPane to frame
    } // end TabbedFrame constructor
} // end class TabbedFrame

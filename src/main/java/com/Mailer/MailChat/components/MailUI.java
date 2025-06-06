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
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.Mailer.MailChat.components.Layout.MessageListPanel;
import com.Mailer.MailChat.components.Layout.MessageViewPanel;
import com.Mailer.MailChat.components.Layout.TitlePane;
import com.Mailer.MailChat.components.Layout.RibbonPanel;
import com.Mailer.MailChat.components.Layout.SidebarPanel;
import com.Mailer.MailChat.controllers.MessageController;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.sun.mail.util.MailConnectException;
import com.sun.mail.util.SocketConnectException;

public class MailUI extends JFrame {
    public MailUI() throws IOException, MailConnectException, SocketException, SocketConnectException {
        super("Mailer");
        TitlePane titlePane = null;
        String errMsgString = "";

        try {
            setLayout(new BorderLayout());

            // String errMsg = "";

            JPanel headerSectionPanel = new JPanel(new BorderLayout());

            FlatSVGIcon appIcon = new FlatSVGIcon("icons/inbox.svg", 16, 16);

            // Title Pane for title and close button
            titlePane = new TitlePane(this, "MailChat", appIcon, errMsgString);
            titlePane.setPreferredSize(new Dimension(0, 40));
            headerSectionPanel.add(titlePane, BorderLayout.NORTH);
            headerSectionPanel.add(new RibbonPanel(), BorderLayout.CENTER);

            add(headerSectionPanel, BorderLayout.NORTH);

            // Sections controlled by sidebar
            MessageListPanel messageListPanel = new MessageListPanel();
            MessageViewPanel messageViewPanel = new MessageViewPanel();

            // Message Controller contains methods to assist sidebar panel actions
            MessageController controller = new MessageController(
                    /* new MessageService().getMessages("Inbox"), */messageListPanel, messageViewPanel);
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
        } catch (Exception error) {
            errMsgString = "Network error";
        }
    } // end TabbedFrame constructor
} // end class TabbedFrame

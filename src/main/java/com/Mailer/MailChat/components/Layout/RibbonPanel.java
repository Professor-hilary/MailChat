package com.Mailer.MailChat.components.Layout;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.icon.EmptyResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.JRibbon;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;

public class RibbonPanel extends JRibbon {
    public RibbonPanel(){
        // Ribbon band section
        JRibbonBand homeBand = new JRibbonBand("Message Tools",new EmptyResizableIcon(32));
        homeBand.addCommandButton(new JCommandButton("Reply",null),RibbonElementPriority.TOP);
        homeBand.addCommandButton(new JCommandButton("Forward",null),RibbonElementPriority.TOP);
        homeBand.addCommandButton(new JCommandButton("Delete",null),RibbonElementPriority.MEDIUM);

        // Adding band to task tab
        RibbonTask homeTask = new RibbonTask("Home", homeBand);
        
        // Ribbon band section
        JRibbonBand composeBand = new JRibbonBand("Editing / Attachment",new EmptyResizableIcon(32));
        composeBand.addCommandButton(new JCommandButton("Font",null),RibbonElementPriority.TOP);
        composeBand.addCommandButton(new JCommandButton("Attach File",null),RibbonElementPriority.TOP);
        composeBand.addCommandButton(new JCommandButton("Emoji",null),RibbonElementPriority.TOP);
        composeBand.addCommandButton(new JCommandButton("Send",null),RibbonElementPriority.MEDIUM);

        // Adding band to task tab
        RibbonTask composeTask = new RibbonTask("Home", composeBand);
        
        // Ribbon band section
        JRibbonBand viewBand = new JRibbonBand("Layout / Filters",new EmptyResizableIcon(32));
        viewBand.addCommandButton(new JCommandButton("Show Starred",null),RibbonElementPriority.TOP);
        viewBand.addCommandButton(new JCommandButton("Show Unread",null),RibbonElementPriority.MEDIUM);

        // Adding band to task tab
        RibbonTask viewTask = new RibbonTask("Home", viewBand);
        
        // Ribbon band section
        JRibbonBand toolsBand = new JRibbonBand("Export / Settings",new EmptyResizableIcon(32));
        toolsBand.addCommandButton(new JCommandButton("Export",null),RibbonElementPriority.TOP);
        toolsBand.addCommandButton(new JCommandButton("Preferences",null),RibbonElementPriority.TOP);
        toolsBand.addCommandButton(new JCommandButton("Theme",null),RibbonElementPriority.MEDIUM);

        // Adding band to task tab
        RibbonTask toolsTask = new RibbonTask("Home", toolsBand);
        
        this.addTask(homeTask);
        this.addTask(composeTask);
        this.addTask(viewTask);
        this.addTask(toolsTask);
    }
}

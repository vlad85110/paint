package kirilov.vladislav.ui.navigation;

import kirilov.vladislav.ui.navigation.menu.ColorsMenu;
import kirilov.vladislav.ui.navigation.menu.DrawersMenu;
import kirilov.vladislav.ui.navigation.menu.MenuButton;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class PaintMenuBar extends JMenuBar {
    public PaintMenuBar(NavigationPanel navigationPanel) {
        JMenu file = new JMenu("File");
        JMenu drawers = new DrawersMenu(navigationPanel.getChooseDrawerPanel());
        JMenu colors = new ColorsMenu(navigationPanel.getChooseColorPanel());
        JMenu settings = new JMenu("Settings");
        JMenu help = new JMenu("Help");

        JMenuItem about = new MenuButton("About", navigationPanel.getMiscellaneousPanel().getShowInfo());
        help.add(about);

        settings.add(new MenuButton("Clear screen",
                navigationPanel.getMiscellaneousPanel().getClearScreen(),
                KeyEvent.VK_X));
        settings.add(new MenuButton("Edit current drawer",
                navigationPanel.getMiscellaneousPanel().getOpenSettings(),
                KeyEvent.VK_C));

        file.add(new MenuButton("Open", navigationPanel.getMiscellaneousPanel().getOpenFile(), KeyEvent.VK_O));
        file.add(new MenuButton("Save", navigationPanel.getMiscellaneousPanel().getSaveFile(), KeyEvent.VK_S));

        add(file);
        add(drawers);
        add(colors);
        add(settings);
        add(help);
    }
}

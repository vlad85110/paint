package kirilov.vladislav.ui.navigation.menu;

import kirilov.vladislav.ui.navigation.panel.color.ChooseColorPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ColorsMenu extends JMenu {
    public ColorsMenu(ChooseColorPanel chooseColorPanel) {
        super("Color");

        add(new MenuButton("Black", chooseColorPanel.getGetChooseBlack(), KeyEvent.VK_0));
        add(new MenuButton("Red", chooseColorPanel.getGetChooseRed(), KeyEvent.VK_R));
        add(new MenuButton("Yellow", chooseColorPanel.getGetChooseYellow(), KeyEvent.VK_Y));
        add(new MenuButton("Green", chooseColorPanel.getGetChooseGreen(), KeyEvent.VK_G));
        add(new MenuButton("Blue", chooseColorPanel.getGetChooseBlue(), KeyEvent.VK_B));
        add(new MenuButton("White", chooseColorPanel.getGetChooseWhite(), KeyEvent.VK_W));
        add(new MenuButton("Custom", chooseColorPanel.getGetChooseCustom(), -1));
    }
}

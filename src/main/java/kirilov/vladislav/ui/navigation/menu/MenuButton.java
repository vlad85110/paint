package kirilov.vladislav.ui.navigation.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuButton extends JMenuItem {

    public MenuButton(String text, Runnable onClick, int key) {
        super(text);
        if (key != -1) {
            setAccelerator(KeyStroke.getKeyStroke(key, ActionEvent.CTRL_MASK));
        }
        addActionListener(e -> onClick.run());
    }

    public MenuButton(String text, Runnable onClick) {
        super(text);
        addActionListener(e -> onClick.run());
    }

}

package kirilov.vladislav.ui.navigation.menu;

import javax.swing.*;

public class MenuRadioButton extends JRadioButton {
    public MenuRadioButton(String text, Runnable onClick, boolean selected) {
        super(text);
        setSelected(selected);
        addActionListener(e -> {
            onClick.run();
        });
    }
}

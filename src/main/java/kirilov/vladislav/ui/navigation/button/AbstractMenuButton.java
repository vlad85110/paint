package kirilov.vladislav.ui.navigation.button;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractMenuButton extends JButton {
    protected String name;

    public AbstractMenuButton(String iconPath, String name) {
        super(new ImageIcon(iconPath));
        setFocusPainted(false);
        setToolTipText(name);
        this.name = name;
        setMouseListener();
    }

    private void setMouseListener() {
        var mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onMouseClicked();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                onMouseClicked();
            }
        };

        addMouseListener(mouseAdapter);
    }

    public abstract void onMouseClicked();
}

package kirilov.vladislav.ui.navigation.panel;

import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;

import javax.swing.*;

public abstract class AbstractSwitchPanel extends JPanel {
    protected AbstractSwitchButton chosenButton = null;

    protected void setChosenButton(AbstractSwitchButton chosenButton) {
        if (this.chosenButton != null) {
            this.chosenButton.setActive(true);
        }

        this.chosenButton = chosenButton;

        if (this.chosenButton != null) {
            this.chosenButton.setActive(false);
        }
    }
}

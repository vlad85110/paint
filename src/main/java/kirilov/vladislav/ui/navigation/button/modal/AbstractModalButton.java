package kirilov.vladislav.ui.navigation.button.modal;

import kirilov.vladislav.ui.navigation.button.AbstractMenuButton;

import javax.swing.*;

public abstract class AbstractModalButton extends AbstractMenuButton {
    private final String name;

    public AbstractModalButton(String iconPath, String name) {
        super(iconPath, name);
        this.name = name;
    }

    @Override
    public void onMouseClicked() {
        var res = showDialog();

        while (!res) {
            res = showDialog();
        }
    }

    protected boolean showDialog() {
        var res = JOptionPane.showConfirmDialog(this, getMessage(), name,
                getOptionType(), getMessageType());

        if (res == JOptionPane.OK_OPTION) {
            return isOk();
        }

        return true;
    }

    protected abstract Object getMessage();

    protected abstract int getOptionType();

    protected abstract int getMessageType();

    protected boolean isOk() {
        return true;
    }
}

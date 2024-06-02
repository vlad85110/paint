package kirilov.vladislav.ui.navigation.button.settings;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.ui.navigation.button.modal.AbstractModalButton;

import javax.swing.*;
import java.util.function.Supplier;

public class SettingsButton extends AbstractModalButton {
    private final Supplier<Drawer> getDrawer;

    public SettingsButton(String iconPath, String name, Supplier<Drawer> getDrawer) {
        super(iconPath, name);
        this.getDrawer = getDrawer;
    }

    @Override
    protected Object getMessage() {
        return getDrawer.get().getConfigEditor().getConfigForm();
    }

    @Override
    protected int getOptionType() {
        return JOptionPane.OK_CANCEL_OPTION;
    }

    @Override
    protected int getMessageType() {
        return JOptionPane.QUESTION_MESSAGE;
    }

    @Override
    protected boolean isOk() {
        var configEditor = getDrawer.get().getConfigEditor();
        return configEditor.validateAndSet();
    }
}

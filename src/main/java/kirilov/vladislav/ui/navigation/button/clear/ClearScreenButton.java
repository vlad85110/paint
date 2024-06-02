package kirilov.vladislav.ui.navigation.button.clear;

import kirilov.vladislav.ui.navigation.button.AbstractMenuButton;

public class ClearScreenButton extends AbstractMenuButton {
    private final Runnable clearScreen;

    public ClearScreenButton(String iconPath, String name, Runnable clearScreen) {
        super(iconPath, name);
        this.clearScreen = clearScreen;
    }

    @Override
    public void onMouseClicked() {
        clearScreen.run();
    }
}

package kirilov.vladislav.ui.navigation.panel;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.ui.canvas.CanvasPanel;
import kirilov.vladislav.ui.navigation.button.clear.ClearScreenButton;
import kirilov.vladislav.ui.navigation.button.file.OpenFileButton;
import kirilov.vladislav.ui.navigation.button.file.SaveFileButton;
import kirilov.vladislav.ui.navigation.button.modal.InfoButton;
import kirilov.vladislav.ui.navigation.button.settings.SettingsButton;

import javax.swing.*;
import java.io.File;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MiscellaneousPanel extends JPanel {
    private final Runnable clearScreen;
    private final Runnable openSettings;
    private final Runnable showInfo;
    private final Runnable saveFile;
    private final Runnable openFile;

    public MiscellaneousPanel(CanvasPanel canvas) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        ClearScreenButton clearScreenButton = new ClearScreenButton("src/main/resources/icons/eraser.png",
                "Clear screen", canvas::clearScreen);
        InfoButton infoButton = new InfoButton("src/main/resources/icons/info.png", "Info");
        SettingsButton settingsButton = new SettingsButton("src/main/resources/icons/settings.png",
                "settings", canvas::getDrawer);

        SaveFileButton saveFileButton = new SaveFileButton("src/main/resources/icons/save.png",
                "Save file", canvas::getCanvas);

        OpenFileButton openFileButton = new OpenFileButton("src/main/resources/icons/file.png",
                "Open file", canvas::setImage);

        this.clearScreen = clearScreenButton::onMouseClicked;
        this.openSettings = settingsButton::onMouseClicked;
        this.showInfo = infoButton::onMouseClicked;
        this.saveFile = saveFileButton::onMouseClicked;
        this.openFile = openFileButton::onMouseClicked;

        add(clearScreenButton);
        add(infoButton);
        add(settingsButton);
//        add(openFileButton);
//        add(saveFileButton);
    }

    public Runnable getClearScreen() {
        return clearScreen;
    }

    public Runnable getOpenSettings() {
        return openSettings;
    }

    public Runnable getShowInfo() {
        return showInfo;
    }

    public Runnable getSaveFile() {
        return saveFile;
    }

    public Runnable getOpenFile() {
        return openFile;
    }
}

package kirilov.vladislav.ui.navigation.button.file;

import kirilov.vladislav.ui.navigation.button.AbstractMenuButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.function.Consumer;

public class OpenFileButton extends AbstractMenuButton {
    private final Consumer<File> setImage;

    public OpenFileButton(String iconPath, String name, Consumer<File> setImage) {
        super(iconPath, name);
        this.setImage = setImage;
    }

    @Override
    public void onMouseClicked() {
        FileDialog fd = new FileDialog(new JFrame(), name, FileDialog.LOAD);
        var fileNameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches("(.*?).(jpg|gif|jpeg|pdf|png|bmp)");
            }
        };

        fd.setFilenameFilter(fileNameFilter);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            setImage.accept(new File(fd.getDirectory() + fd.getFile()));
        }
    }
}

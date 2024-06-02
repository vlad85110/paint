package kirilov.vladislav.ui.navigation.button.file;

import kirilov.vladislav.ui.navigation.button.AbstractMenuButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public class SaveFileButton extends AbstractMenuButton {
    private final Supplier<BufferedImage> getImage;

    public SaveFileButton(String iconPath, String name, Supplier<BufferedImage> getImage) {
        super(iconPath, name);
        this.getImage = getImage;
    }

    @Override
    public void onMouseClicked() {
        FileDialog fd = new FileDialog(new JFrame(), name, FileDialog.SAVE);
        fd.setDirectory(System.getProperty("user.dir"));
        fd.setFile("*.png");
        fd.setVisible(true);

        var fileName = fd.getFile();

        if (fileName != null) {
            if (!fileName.endsWith(".png")) {
                fileName = fileName + ".png";
            }

            File file = new File(fd.getDirectory(), fileName);

            try {
                ImageIO.write(getImage.get(), "png", file);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Ошибка при сохранении файла");
            }
        }
    }
}

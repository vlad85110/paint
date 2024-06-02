package kirilov.vladislav.ui.navigation.button.modal;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class InfoButton extends AbstractModalButton {
    private String message = "";

    public InfoButton(String iconPath, String name) {
        super(iconPath, name);

        try (FileInputStream inputStream = new FileInputStream("src/main/resources/about.txt")) {
            message = new String(inputStream.readAllBytes());
        } catch (IOException e) {
            System.err.println("unable to read about.txt");
        }
    }

    @Override
    protected Object getMessage() {
        return message;
    }

    @Override
    protected int getOptionType() {
        return JOptionPane.DEFAULT_OPTION;
    }

    @Override
    protected int getMessageType() {
        return JOptionPane.INFORMATION_MESSAGE;
    }
}

package kirilov.vladislav.ui.navigation.button.color;

import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;
import kirilov.vladislav.ui.navigation.button.modal.AbstractModalButton;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CustomColorButton extends AbstractModalButton {
    private final JColorChooser colorChooser = new JColorChooser();

    private final Consumer<Color> setColor;
    private final  Consumer<AbstractSwitchButton> setChosen;

    public CustomColorButton(String iconPath, String name, Consumer<Color> setColor,
                             Consumer<AbstractSwitchButton> setChosen) {
        super(iconPath, name);
        this.setColor = setColor;
        this.setChosen = setChosen;
    }

    @Override
    protected Object getMessage() {
        return colorChooser;
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
        setColor.accept(colorChooser.getColor());
        setChosen.accept(null);
        return true;
    }
}

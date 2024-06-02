package kirilov.vladislav.ui.navigation.panel.color;

import kirilov.vladislav.ui.navigation.button.color.ChooseColorButton;
import kirilov.vladislav.ui.navigation.button.color.CustomColorButton;
import kirilov.vladislav.ui.navigation.panel.AbstractSwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ChooseColorPanel extends AbstractSwitchPanel {
    private final Runnable getChooseRed;
    private final Runnable getChooseBlack;
    private final Runnable getChooseYellow;
    private final Runnable getChooseGreen;
    private final Runnable getChooseBlue;
    private final Runnable getChooseWhite;
    private final Runnable getChooseCustom;

    public ChooseColorPanel(Consumer<Color> setColor) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        String iconPathPrefix = "src/main/resources/icons/color/";

        ChooseColorButton redButton = new ChooseColorButton(iconPathPrefix + "redSquare.png",
                "Red", Color.RED,
                setColor, this::setChosenButton);
        getChooseRed = redButton::onMouseClicked;

        ChooseColorButton blackButton = new ChooseColorButton(iconPathPrefix + "blackSquare.png",
                "Black", Color.BLACK, setColor, this::setChosenButton);
        getChooseBlack = blackButton::onMouseClicked;

        ChooseColorButton yellowButton = new ChooseColorButton(iconPathPrefix + "yellowSquare.png",
                "Yellow", Color.YELLOW, setColor, this::setChosenButton);
        getChooseYellow = yellowButton::onMouseClicked;

        ChooseColorButton greenButton = new ChooseColorButton(iconPathPrefix + "greenSquare.png",
                "Green", Color.GREEN, setColor, this::setChosenButton);
        getChooseGreen = greenButton::onMouseClicked;

        ChooseColorButton blueButton = new ChooseColorButton(iconPathPrefix + "blueSquare.png",
                "Blue", Color.BLUE, setColor, this::setChosenButton);
        getChooseBlue = blueButton::onMouseClicked;

        ChooseColorButton whiteButton = new ChooseColorButton(iconPathPrefix + "whiteSquare.png",
                "White", Color.WHITE, setColor, this::setChosenButton);
        getChooseWhite = whiteButton::onMouseClicked;

        CustomColorButton customColorButton = new CustomColorButton(iconPathPrefix + "palette.png",
                "Произвольный цвет", setColor, this::setChosenButton);
        getChooseCustom = customColorButton::onMouseClicked;

        blackButton.onMouseClicked();
        add(blackButton);
        add(redButton);
        add(yellowButton);
        add(greenButton);
        add(blueButton);
        add(whiteButton);
        add(customColorButton);
    }

    public Runnable getGetChooseRed() {
        return getChooseRed;
    }

    public Runnable getGetChooseBlack() {
        return getChooseBlack;
    }

    public Runnable getGetChooseYellow() {
        return getChooseYellow;
    }

    public Runnable getGetChooseGreen() {
        return getChooseGreen;
    }

    public Runnable getGetChooseBlue() {
        return getChooseBlue;
    }

    public Runnable getGetChooseWhite() {
        return getChooseWhite;
    }

    public Runnable getGetChooseCustom() {
        return getChooseCustom;
    }
}

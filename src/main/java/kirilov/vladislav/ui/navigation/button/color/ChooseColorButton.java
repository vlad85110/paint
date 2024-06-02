package kirilov.vladislav.ui.navigation.button.color;

import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;
import kirilov.vladislav.ui.navigation.menu.MenuRadioButton;

import java.awt.*;
import java.util.function.Consumer;

public class ChooseColorButton extends AbstractSwitchButton {
    private final Consumer<Color> setColor;
    private final Color color;

    public ChooseColorButton(String iconPath, String name, Color color, Consumer<Color> setColor,
                             Consumer<AbstractSwitchButton> setChosen) {
        super(iconPath, name, setChosen);
        this.setColor = setColor;
        this.color = color;
    }

    @Override
    public void onMouseClicked() {
        super.onMouseClicked();
        setColor.accept(color);
    }

}

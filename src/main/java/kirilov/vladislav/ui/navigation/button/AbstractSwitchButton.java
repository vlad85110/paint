package kirilov.vladislav.ui.navigation.button;

import java.awt.*;
import java.util.function.Consumer;

public abstract class AbstractSwitchButton extends AbstractMenuButton {
    protected final Consumer<AbstractSwitchButton> setChosen;

    public AbstractSwitchButton(String iconPath, String name, Consumer<AbstractSwitchButton> setChosen) {
        super(iconPath, name);
        this.setChosen = setChosen;
    }

    public void setActive(boolean value) {
        setBorderPainted(value);
    }

    @Override
    public void onMouseClicked() {
        setChosen.accept(this);
    }
}

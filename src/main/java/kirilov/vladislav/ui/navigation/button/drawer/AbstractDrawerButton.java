package kirilov.vladislav.ui.navigation.button.drawer;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;
import kirilov.vladislav.ui.navigation.menu.MenuRadioButton;

import java.util.function.Consumer;

public abstract class AbstractDrawerButton extends AbstractSwitchButton {
    private final Consumer<Drawer> setDrawer;

    private final MenuRadioButton radioButton;

    public AbstractDrawerButton(String iconPath, String name, Consumer<Drawer> setDrawer, Consumer<AbstractSwitchButton> setChosen) {
        super(iconPath, name, setChosen);
        this.setDrawer = setDrawer;

        radioButton = new MenuRadioButton(name, this::onMouseClicked, false);
    }

    @Override
    public void onMouseClicked() {
        super.onMouseClicked();
        setDrawer.accept(getDrawer());
    }

    protected abstract Drawer getDrawer();

    public MenuRadioButton getRadioButton() {
        return radioButton;
    }
}

package kirilov.vladislav.ui.navigation.button.drawer;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.tool.star.StarDrawer;
import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;

import java.util.function.Consumer;

public class StarDrawerButton extends AbstractDrawerButton {
    private final StarDrawer starDrawer;

    public StarDrawerButton(String iconPath, String name, Consumer<Drawer> setDrawer, Consumer<AbstractSwitchButton> setChosen, int pointsCnt) {
        super(iconPath, name, setDrawer, setChosen);
        starDrawer = new StarDrawer(pointsCnt);
    }

    @Override
    protected Drawer getDrawer() {
        return starDrawer;
    }
}

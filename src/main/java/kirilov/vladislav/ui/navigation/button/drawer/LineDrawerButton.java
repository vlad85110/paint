package kirilov.vladislav.ui.navigation.button.drawer;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.tool.line.SingleLineDrawer;
import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;

import java.util.function.Consumer;

public class LineDrawerButton extends AbstractDrawerButton {
    private final SingleLineDrawer lineDrawer = new SingleLineDrawer();

    public LineDrawerButton(String iconPath, String name, Consumer<Drawer> setDrawer,
                            Consumer<AbstractSwitchButton> setChosen) {
        super(iconPath, name, setDrawer, setChosen);
    }

    @Override
    protected Drawer getDrawer() {
        return lineDrawer;
    }
}

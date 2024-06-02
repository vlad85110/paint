package kirilov.vladislav.ui.navigation.button.drawer;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.tool.polygon.PolygonDrawer;
import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;

import java.util.function.Consumer;

public class PolygonDrawerButton extends AbstractDrawerButton {
    private final PolygonDrawer polygonDrawer;

    public PolygonDrawerButton(String iconPath, String name, Consumer<Drawer> setDrawer, Consumer<AbstractSwitchButton> setChosen,
                               int angleCnt) {
        super(iconPath, name, setDrawer, setChosen);
        polygonDrawer = new PolygonDrawer(angleCnt);
    }

    @Override
    protected Drawer getDrawer() {
        return polygonDrawer;
    }
}

package kirilov.vladislav.ui.navigation.button.drawer;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.tool.span.SpanFiller;
import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;

import java.util.function.Consumer;

public class SpanFillerButton extends AbstractDrawerButton {
    private final SpanFiller spanFiller = new SpanFiller();

    public SpanFillerButton(String iconPath, String name, Consumer<Drawer> setDrawer, Consumer<AbstractSwitchButton> setChosen) {
        super(iconPath, name, setDrawer, setChosen);
    }

    @Override
    protected Drawer getDrawer() {
        return spanFiller;
    }
}

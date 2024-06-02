package kirilov.vladislav.ui.navigation.panel.drawer;

import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.ui.navigation.button.AbstractSwitchButton;
import kirilov.vladislav.ui.navigation.button.drawer.*;
import kirilov.vladislav.ui.navigation.panel.AbstractSwitchPanel;

import javax.swing.*;
import java.util.function.Consumer;

public class ChooseDrawerPanel extends AbstractSwitchPanel {
    private final LineDrawerButton lineDrawerButton;
    private final PolygonDrawerButton pentagonDrawerButton;
    private final StarDrawerButton starDrawerButton;
    private final SpanFillerButton spanFillerButton;

    public ChooseDrawerPanel(Consumer<Drawer> setDrawer) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        String iconPathPrefix = "src/main/resources/icons/drawer/";

        this.lineDrawerButton = new LineDrawerButton(iconPathPrefix + "line.png",
                "Line", setDrawer, this::setChosenButton);
        this.pentagonDrawerButton = new PolygonDrawerButton(iconPathPrefix +
                "pentagon.png", "Polygon", setDrawer, this::setChosenButton, 5);
        this.starDrawerButton = new StarDrawerButton(iconPathPrefix + "4-star.png",
                "Star", setDrawer, this::setChosenButton, 4);
        this.spanFillerButton = new SpanFillerButton(iconPathPrefix + "filler.png",
                "Filler", setDrawer, this::setChosenButton);

        lineDrawerButton.onMouseClicked();
        add(lineDrawerButton);
        add(pentagonDrawerButton);
        add(starDrawerButton);
        add(spanFillerButton);
    }
    @Override
    protected void setChosenButton(AbstractSwitchButton chosenButton) {
        if (this.chosenButton != null) {
            this.chosenButton.setActive(true);
            ((AbstractDrawerButton) this.chosenButton).getRadioButton().setSelected(false);
        }

        this.chosenButton = chosenButton;

        if (this.chosenButton != null) {
            this.chosenButton.setActive(false);
            ((AbstractDrawerButton) chosenButton).getRadioButton().setSelected(true);
        }
    }

    public LineDrawerButton getLineDrawerButton() {
        return lineDrawerButton;
    }

    public PolygonDrawerButton getPentagonDrawerButton() {
        return pentagonDrawerButton;
    }

    public StarDrawerButton getStarDrawerButton() {
        return starDrawerButton;
    }

    public SpanFillerButton getSpanFillerButton() {
        return spanFillerButton;
    }
}

package kirilov.vladislav.ui.navigation;

import kirilov.vladislav.ui.canvas.CanvasPanel;
import kirilov.vladislav.ui.navigation.panel.MiscellaneousPanel;
import kirilov.vladislav.ui.navigation.panel.color.ChooseColorPanel;
import kirilov.vladislav.ui.navigation.panel.drawer.ChooseDrawerPanel;

import javax.swing.*;

public class NavigationPanel extends JPanel {
    private final ChooseDrawerPanel chooseDrawerPanel;
    private final ChooseColorPanel chooseColorPanel;
    private final MiscellaneousPanel miscellaneousPanel;

    public NavigationPanel(CanvasPanel canvas) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        chooseDrawerPanel = new ChooseDrawerPanel(canvas::setDrawer);
        add(chooseDrawerPanel);
        chooseColorPanel = new ChooseColorPanel(canvas::setColor);
        add(chooseColorPanel);
        miscellaneousPanel = new MiscellaneousPanel(canvas);
        add(miscellaneousPanel);
    }

    public ChooseDrawerPanel getChooseDrawerPanel() {
        return chooseDrawerPanel;
    }

    public ChooseColorPanel getChooseColorPanel() {
        return chooseColorPanel;
    }

    public MiscellaneousPanel getMiscellaneousPanel() {
        return miscellaneousPanel;
    }
}


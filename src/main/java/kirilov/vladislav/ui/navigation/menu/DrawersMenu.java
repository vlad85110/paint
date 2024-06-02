package kirilov.vladislav.ui.navigation.menu;

import kirilov.vladislav.ui.navigation.panel.drawer.ChooseDrawerPanel;

import javax.swing.*;

public class DrawersMenu extends JMenu {
    public DrawersMenu(ChooseDrawerPanel chooseDrawerPanel) {
        super("Instrument");

        var line = chooseDrawerPanel.getLineDrawerButton().getRadioButton();
        var polygon = chooseDrawerPanel.getPentagonDrawerButton().getRadioButton();
        var star = chooseDrawerPanel.getStarDrawerButton().getRadioButton();
        var filler = chooseDrawerPanel.getSpanFillerButton().getRadioButton();

        add(line);
        add(polygon);
        add(star);
        add(filler);
    }
}

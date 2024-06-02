package kirilov.vladislav.config;

import kirilov.vladislav.ui.input.number.NumberInputWithLabel;
import kirilov.vladislav.ui.input.TextInputWithLabel;

public class AbstractLineDrawerConfigEditor extends DrawerConfigEditor {
    public AbstractLineDrawerConfigEditor(int thickness) {
        TextInputWithLabel thicknessInput = new NumberInputWithLabel("Толщина", 1, 100, thickness);
        inputPanel.add(thicknessInput);
        inputs.put("thickness", thicknessInput);
    }
}

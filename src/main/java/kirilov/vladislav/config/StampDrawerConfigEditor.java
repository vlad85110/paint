package kirilov.vladislav.config;

import kirilov.vladislav.config.AbstractLineDrawerConfigEditor;
import kirilov.vladislav.ui.input.number.NumberInputWithLabel;
import kirilov.vladislav.ui.input.TextInputWithLabel;

public abstract class StampDrawerConfigEditor extends AbstractLineDrawerConfigEditor {
    public StampDrawerConfigEditor(int angle, int thickness, int pointsCnt) {
        super(thickness);
        NumberInputWithLabel pointsCntInput = new NumberInputWithLabel("Количество вершин", 3, 16,
                pointsCnt);
        TextInputWithLabel angleInput = new NumberInputWithLabel("Угол Поворота", 0, 359, angle);
        inputPanel.add(angleInput);
        inputPanel.add(pointsCntInput);
        inputs.put("angle", angleInput);
        inputs.put("pointsCnt", pointsCntInput);
    }
}

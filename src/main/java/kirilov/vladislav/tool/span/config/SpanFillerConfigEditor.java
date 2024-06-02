package kirilov.vladislav.tool.span.config;

import kirilov.vladislav.config.DrawerConfigEditor;

import javax.swing.*;

public class SpanFillerConfigEditor extends DrawerConfigEditor {
    @Override
    public JComponent getConfigForm() {
        return new JLabel("Параметры заливки определяюся Цветом, который выбирается на панели инструментов");
    }
}

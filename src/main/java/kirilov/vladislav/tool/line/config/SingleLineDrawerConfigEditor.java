package kirilov.vladislav.tool.line.config;

import kirilov.vladislav.config.AbstractLineDrawerConfigEditor;
import kirilov.vladislav.tool.line.SingleLineDrawer;

public class SingleLineDrawerConfigEditor extends AbstractLineDrawerConfigEditor {
    private final SingleLineDrawer lineDrawer;

    public SingleLineDrawerConfigEditor(SingleLineDrawer lineDrawer) {
        super(lineDrawer.getThickness());
        this.lineDrawer = lineDrawer;
    }

    @Override
    protected void editDrawer() {
        var thickness = inputs.get("thickness").getText();
        lineDrawer.setThickness(Integer.parseInt(thickness));
    }
}

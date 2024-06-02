package kirilov.vladislav.tool.polygon.config;

import kirilov.vladislav.config.StampDrawerConfigEditor;
import kirilov.vladislav.tool.polygon.PolygonDrawer;
import kirilov.vladislav.ui.input.number.NumberInputWithLabel;
import kirilov.vladislav.ui.input.TextInputWithLabel;

public class PolygonDrawerConfigEditor extends StampDrawerConfigEditor {
    private final PolygonDrawer polygonDrawer;

    public PolygonDrawerConfigEditor(PolygonDrawer polygonDrawer) {
        super(polygonDrawer.getAngle(), polygonDrawer.getThickness(), polygonDrawer.getPointsCnt());

        this.polygonDrawer = polygonDrawer;
        TextInputWithLabel radiusInput = new NumberInputWithLabel("Радиус", 1, 999,
                polygonDrawer.getRadius());
        inputs.put("radius", radiusInput);
        inputPanel.add(radiusInput);
    }

    @Override
    protected void editDrawer() {
        var thickness = inputs.get("thickness").getText();
        polygonDrawer.setThickness(Integer.parseInt(thickness));

        var angle = inputs.get("angle").getText();
        polygonDrawer.setAngle(Integer.parseInt(angle));

        var pointsCnt = inputs.get("pointsCnt").getText();
        polygonDrawer.setPointsCnt(Integer.parseInt(pointsCnt));

        var radius = inputs.get("radius").getText();
        polygonDrawer.setRadius(Integer.parseInt(radius));
    }
}

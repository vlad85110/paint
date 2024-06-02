package kirilov.vladislav.tool.star.config;

import kirilov.vladislav.config.StampDrawerConfigEditor;
import kirilov.vladislav.tool.star.StarDrawer;
import kirilov.vladislav.ui.input.number.NumberInputWithLabel;
import kirilov.vladislav.ui.input.TextInputWithLabel;

public class StarDrawerConfigEditor extends StampDrawerConfigEditor {
    private final StarDrawer starDrawer;

    public StarDrawerConfigEditor(StarDrawer starDrawer) {
        super(starDrawer.getAngle(), starDrawer.getThickness(), starDrawer.getPointsCnt());
        this.starDrawer = starDrawer;

        TextInputWithLabel innerRadiusInput = new NumberInputWithLabel("Внутренний радиус", 1,
                1001, starDrawer.getInnerRadius());
        TextInputWithLabel outerRadiusInput = new NumberInputWithLabel("Внешний радиус", 2,
                1000, starDrawer.getOuterRadius());

        inputPanel.add(innerRadiusInput);
        inputPanel.add(outerRadiusInput);
        inputs.put("inner radius", innerRadiusInput);
        inputs.put("outer radius", outerRadiusInput);
    }

    @Override
    protected void editDrawer() {
        var thickness = inputs.get("thickness").getText();
        starDrawer.setThickness(Integer.parseInt(thickness));

        var pointsCnt = inputs.get("pointsCnt").getText();
        starDrawer.setPointsCnt(Integer.parseInt(pointsCnt));

        var angle = inputs.get("angle").getText();
        starDrawer.setAngle(Integer.parseInt(angle));

        var innerRadius = inputs.get("inner radius").getText();
        starDrawer.setInnerRadius(Integer.parseInt(innerRadius));

        var outerRadius = inputs.get("outer radius").getText();
        starDrawer.setOuterRadius(Integer.parseInt(outerRadius));
    }
}

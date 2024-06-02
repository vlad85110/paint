package kirilov.vladislav.tool.star;

import kirilov.vladislav.config.DrawerConfigEditor;
import kirilov.vladislav.config.StampDrawerConfigEditor;
import kirilov.vladislav.tool.star.config.StarDrawerConfigEditor;
import kirilov.vladislav.tool.line.SingleLineDrawer;
import kirilov.vladislav.tool.StampDrawer;
import kirilov.vladislav.math.coords.PolarCords;
import kirilov.vladislav.ui.canvas.CanvasPanel;

public class StarDrawer extends StampDrawer {
    private int innerRadius = 30;
    private int outerRadius = 100;

    public StarDrawer(int pointsCnt) {
        super(pointsCnt);
    }

    @Override
    public void draw(CanvasPanel canvas, int x1, int y1, int x2, int y2) {
        double dAngle = 360.0 / (pointsCnt * 2);

        SingleLineDrawer lineDrawer = new SingleLineDrawer();
        lineDrawer.setThickness(thickness);

        var prevPolarCoords = new PolarCords(angle + 90, outerRadius);
        var prevCartesianCords = prevPolarCoords.toCartesian();

        for (int i = 1; i <= pointsCnt * 2; i++) {
            int radius;

            if (i % 2 == 0) {
                radius = outerRadius;
            } else {
                radius = innerRadius;
            }

            var outerPointPolarCords = new PolarCords(i * dAngle + angle + 90, radius);
            var outerPointCartesianCords = outerPointPolarCords.toCartesian();

            lineDrawer.draw(canvas, (int) (prevCartesianCords.x() + x1), (int) (prevCartesianCords.y() + y1),
                    (int) (outerPointCartesianCords.x() + x1), (int) (outerPointCartesianCords.y() + y1));

            prevCartesianCords = outerPointCartesianCords;
        }
    }

    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }

    public int getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(int outerRadius) {
        this.outerRadius = outerRadius;
    }

    private final StampDrawerConfigEditor configEditor = new StarDrawerConfigEditor(this);

    @Override
    public DrawerConfigEditor getConfigEditor() {
        return configEditor;
    }
}

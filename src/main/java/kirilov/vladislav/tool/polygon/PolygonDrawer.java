package kirilov.vladislav.tool.polygon;

import kirilov.vladislav.config.DrawerConfigEditor;
import kirilov.vladislav.tool.polygon.config.PolygonDrawerConfigEditor;
import kirilov.vladislav.ui.canvas.CanvasPanel;
import kirilov.vladislav.math.coords.PolarCords;
import kirilov.vladislav.tool.line.SingleLineDrawer;
import kirilov.vladislav.tool.StampDrawer;

public class PolygonDrawer extends StampDrawer {
    protected int radius = 100;

    public PolygonDrawer(int pointsCnt) {
        super(pointsCnt);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(CanvasPanel canvas, int x1, int y1, int x2, int y2) {
        double dAngle = 360.0 / pointsCnt;

        SingleLineDrawer lineDrawer = new SingleLineDrawer();
        lineDrawer.setThickness(thickness);

        var prevPolarCoords = new PolarCords(270 + angle, radius);
        var prevCartesianCords = prevPolarCoords.toCartesian();

        for (int i = 1; i <= pointsCnt; i++) {
            var polarCords = new PolarCords(i * dAngle + 270 + angle, radius);
            var cartesianCords = polarCords.toCartesian();

            lineDrawer.draw(canvas, (int)(prevCartesianCords.x() + x1), (int)(prevCartesianCords.y() + y1),
                    (int)(cartesianCords.x() + x1), (int)(cartesianCords.y() + y1));

            prevCartesianCords = cartesianCords;
        }
    }

    private final PolygonDrawerConfigEditor configEditor = new PolygonDrawerConfigEditor(this);

    @Override
    public DrawerConfigEditor getConfigEditor() {
        return configEditor;
    }
}

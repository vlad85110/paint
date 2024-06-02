package kirilov.vladislav.tool.line;

import kirilov.vladislav.config.DrawerConfigEditor;
import kirilov.vladislav.tool.line.config.SingleLineDrawerConfigEditor;
import kirilov.vladislav.tool.AbstractLineDrawer;
import kirilov.vladislav.ui.canvas.CanvasPanel;

import java.awt.*;
import java.util.function.Function;

public class SingleLineDrawer extends AbstractLineDrawer {
    @Override
    public void draw(CanvasPanel canvas, int x1, int y1, int x2, int y2) {
        if (thickness != 1) {
            var g = (Graphics2D)canvas.getCanvasGraphics();
            g.setStroke(new BasicStroke(thickness));
            var prevColor = g.getColor();
            g.setColor(canvas.getColor());
            g.drawLine(x1, y1, x2, y2);
            g.setColor(prevColor);
            g.setStroke(new BasicStroke(1));
        } else {
            Function<Integer, Integer> nextY = (y1 >= y2) ? (Integer y) -> --y : (Integer y) -> ++y;
            Function<Integer, Integer> nextX = (x1 >= x2) ? (Integer x) -> --x : (Integer x) -> ++x;

            var dx = Math.abs((double) x2 - (double) x1);
            var dy = Math.abs((double) y2 - (double) y1);

            if (dx == 0 || dy / dx > 1) {
                bresenhamAlgorithm(y1, x1, y2, x2, canvas, nextX, nextY, true);
            } else {
                bresenhamAlgorithm(x1, y1, x2, y2, canvas, nextY, nextX, false);
            }
        }
    }

    private void bresenhamAlgorithm(int x1, int y1, int x2, int y2, CanvasPanel canvas, Function<Integer,
            Integer> nextY, Function<Integer, Integer> nextX, boolean isReverse) {
        var dx = Math.abs(x2 - x1);
        var dy = Math.abs(y2 - y1);

        int x = x1;
        int y = y1;
        int err = -dx;

        for (int i = 0; i < dx; i++) {
            x = nextX.apply(x);
            err += 2 * dy;

            if (err > 0) {
                err -= 2 * dx;
                y = nextY.apply(y);
            }

            try {
                if (isReverse) {
                    canvas.setRGB(y, x);
                } else {
                    canvas.setRGB(x, y);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
    }

    private final SingleLineDrawerConfigEditor configEditor = new SingleLineDrawerConfigEditor(this);

    @Override
    public DrawerConfigEditor getConfigEditor() {
        return configEditor;
    }
}

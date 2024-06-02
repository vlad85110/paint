package kirilov.vladislav.tool.span;

import kirilov.vladislav.config.DrawerConfigEditor;
import kirilov.vladislav.tool.span.config.SpanFillerConfigEditor;
import kirilov.vladislav.tool.Drawer;
import kirilov.vladislav.math.span.Span;
import kirilov.vladislav.ui.canvas.CanvasPanel;

import java.util.Stack;

public class SpanFiller implements Drawer {
    @Override
    public void draw(CanvasPanel canvas, int x1, int y1, int x2, int y2) {
        Stack<Span> stack = new Stack<>();

        int color = canvas.getColor().getRGB();
        int oldInnerColor = canvas.getRGB(x1, y1);

        if (color == oldInnerColor) {
            return;
        }

        var width = canvas.getCanvasWidth();
        var height = canvas.getCanvasHeight();

        Span startSpan = createSpan(x1, y1, oldInnerColor, width, canvas);
        Span span;
        stack.push(startSpan);

        canvas.setRGB(10, 10);

        while (!stack.isEmpty()) {
            span = stack.pop();
            span.fill(canvas);
            int y = span.y();

            if (y != 0) {
                for (int x = span.x1(); x <= span.x2(); x++) {
                    Span newSpan = createSpan(x, y - 1, oldInnerColor, width, canvas);

                    if (newSpan.isLinkedWith(span)) {
                        stack.push(newSpan);
                        x = newSpan.x2();
                    }
                }
            }

            if (y != height - 1) {
                for (int x = span.x1(); x <= span.x2(); x++) {
                    Span newSpan = createSpan(x, y + 1, oldInnerColor, width, canvas);

                    if (newSpan.isLinkedWith(span)) {
                        stack.push(newSpan);
                        x = newSpan.x2();
                    }
                }
            }
        }
    }

    private Span createSpan(int x, int y, int innerColor, int width, CanvasPanel canvas) {
        int spanStart = x;
        while (spanStart != 0) {
            int spanStartColor = canvas.getRGB(spanStart, y);
            if (spanStartColor != innerColor) {
                spanStart++;
                break;
            }
            spanStart--;
        }

        int spanEnd = x;
        while (spanEnd != width - 1) {
            int spanEndColor = canvas.getRGB(spanEnd, y);
            if (spanEndColor != innerColor) {
                spanEnd--;
                break;
            }
            spanEnd++;
        }

        return new Span(y, spanStart, spanEnd);
    }

    @Override
    public DrawerConfigEditor getConfigEditor() {
        return new SpanFillerConfigEditor();
    }
}

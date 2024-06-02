package kirilov.vladislav.math.span;

import kirilov.vladislav.ui.canvas.CanvasPanel;

public record Span(int y, int x1, int x2) {

    public void fill(CanvasPanel canvas) {
        for (int x = x1; x <= x2; x++) {
            canvas.setRGB(x, y);
        }
    }

    public int len() {
        return x2 - x1;
    }

    public boolean isLinkedWith(Span other) {
        int minX = Math.min(x1, other.x1);
        int maxX = Math.max(x2, other.x2);

        return maxX - minX <= (len() + other.len());
    }

    @Override
    public String toString() {
        return "("+ x1 + ", " + x2  + ", " + y + ")";
    }
}

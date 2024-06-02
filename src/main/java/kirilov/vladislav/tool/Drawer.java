package kirilov.vladislav.tool;

import kirilov.vladislav.config.DrawerConfigEditor;
import kirilov.vladislav.ui.canvas.CanvasPanel;

public interface Drawer {
    void draw(CanvasPanel canvas, int x1, int y1, int x2, int y2);
    DrawerConfigEditor getConfigEditor();
}

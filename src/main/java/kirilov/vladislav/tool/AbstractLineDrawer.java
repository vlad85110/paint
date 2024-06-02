package kirilov.vladislav.tool;

public abstract class AbstractLineDrawer implements Drawer {
    protected int thickness = 1;

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}

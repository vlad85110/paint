package kirilov.vladislav.tool;

public abstract class StampDrawer extends AbstractLineDrawer {
    protected int angle = 0;
    protected int pointsCnt;

    public StampDrawer(int pointsCnt) {
        this.pointsCnt = pointsCnt;
    }

    public int getPointsCnt() {
        return pointsCnt;
    }

    public void setPointsCnt(int pointsCnt) {
        this.pointsCnt = pointsCnt;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}

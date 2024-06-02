package kirilov.vladislav.math.coords;

public record CartesianCords(double x, double y){
    public PolarCords toPolar() {
        int r = (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return new PolarCords((int)Math.acos(r / x), r);
    }
}


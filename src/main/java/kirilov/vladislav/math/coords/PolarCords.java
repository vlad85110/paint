package kirilov.vladislav.math.coords;

public record PolarCords(double fi, double r) {
    public CartesianCords toCartesian() {
        var fiInRadians = Math.toRadians(fi);
        var x = (int)(r * Math.cos(fiInRadians));
        var y = (int)(r * Math.sin(fiInRadians));
        return new CartesianCords(x, y);
    }
}

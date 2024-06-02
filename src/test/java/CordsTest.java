import kirilov.vladislav.math.coords.CartesianCords;
import kirilov.vladislav.math.coords.PolarCords;
import org.junit.Assert;
import org.junit.Test;

public class CordsTest {

    @Test
    public void polarToCartesianCordsTest() {
        var polarCoords = new PolarCords(90, 100);
        var cartesianCords = polarCoords.toCartesian();

        Assert.assertEquals(0, cartesianCords.x());
        Assert.assertEquals(100, cartesianCords.y());
    }

    @Test
    public void cartesianToPolarCordsTest() {
        var cartesianCords = new CartesianCords(0, 100);
        var polarCoords = cartesianCords.toPolar();

        Assert.assertEquals(90, polarCoords.fi());
        Assert.assertEquals(100, polarCoords.r());
    }
}

import kirilov.vladislav.math.span.Span;
import org.junit.Assert;
import org.junit.Test;

public class SpanTest {
    @Test
    public void spanLinkTest() {
        Span s1 = new Span(130, 196, 298);
        Span s2 = new Span(130, 0, 195);

        Assert.assertFalse(s2.isLinkedWith(s1));

        s1 = new Span(130, 196, 298);
        s2 = new Span(130, 0, 196);

         Assert.assertTrue(s2.isLinkedWith(s1));
    }
}

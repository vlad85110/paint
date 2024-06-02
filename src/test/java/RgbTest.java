import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class RgbTest {
    private String toBinaryString(int value) {
        var binary = Integer.toBinaryString(value);

        var builder = new StringBuilder();
        for (int i = 0; i <= binary.length() - 8; i += 8) {
            builder.append(binary, i, i + 7);
            builder.append(' ');
        }

        return builder.toString();
    }

    //без операции чистки так как изначально 0ж, но если будут сеттеры то нужно делать
    //в awt еще делается & с 255 чтоб убрать лишнее с других разрядов
    //a = I_прошедшего / I_света;

    @Test
    public void rgbTest() {
        var color = new Color(255, 255, 255);
        var binaryString = toBinaryString(color.getRGB()); // 1111111 1111111 1111111 1111111
        color = new Color(0, 0, 0);
        binaryString = toBinaryString(color.getRGB()); // 1111111 0000000 0000000 0000000
    }

    @Test
    public void MyRgbTest() {
        var myColor = new MyColor(14, 24, 22, 255);
        var color = new Color(14, 24, 22, 255);

        Assert.assertEquals(myColor.getRGB(), color.getRGB());
        Assert.assertEquals(myColor.getAlpha(), color.getAlpha());
        Assert.assertEquals(myColor.getRed(), color.getRed());
        Assert.assertEquals(myColor.getGreen(), color.getGreen());
        Assert.assertEquals(myColor.getBlue(), color.getBlue());
    }
}

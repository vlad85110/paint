public class MyColor {
    private final int value;

    public MyColor(int r, int g, int b) {
        this(r, g, b ,255);
    }

    public MyColor(int r, int g, int b, int a) {
        validateValues(r, g, b, a);
        value = (a << 24) | (r << 16) | (g << 8) | b;
    }

    public int getRGB() {
        return value;
    }

    public int getAlpha() {
        //зануляем остальные разряды
        return (value >> 24) & 255;
    }

    public int getRed() {
        return (value >> 16) & 255;
    }

    public int getGreen() {
        return (value >> 8) & 255;
    }

    public int getBlue() {
        return 255 & value;
    }

    private void validateValues(int r, int g, int b, int a) {}
}

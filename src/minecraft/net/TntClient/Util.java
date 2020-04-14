package net.TntClient;

import java.awt.*;

public class Util {

    public static int getRainbow(){
        return hsvToRgb((float) Math.min(Math.abs(Math.sin(System.currentTimeMillis() / 2000.)), 0.999), 1, 1);
    }

    public static int hsvToRgb(float hue, float saturation, float value) {
        int h = (int) (hue * 6);
        float f = hue * 6 - h;
        float p = value * (1 - saturation);
        float q = value * (1 - f * saturation);
        float t = value * (1 - (1 - f) * saturation);

        switch (h) {
            case 0:
                return rgbToString(value, t, p);
            case 1:
                return rgbToString(q, value, p);
            case 2:
                return rgbToString(p, value, t);
            case 3:
                return rgbToString(p, q, value);
            case 4:
                return rgbToString(t, p, value);
            case 5:
                return rgbToString(value, p, q);
            default:
                throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation + ", " + value);
        }
    }

    public static int rgbToString(float r, float g, float b) {
        return new Color(r, g, b).getRGB();
    }
}

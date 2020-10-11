package supercoder79.superworldgen.math;

public class InterpolationUtil {
    public static double smoothstep(double x) {
        return x * x * ((x * -2.0) + 3.0);
    }

    public static double smootherstep(double x) {
        return x * x * x * (x * (x * 6.0 - 15.0) + 10.0);
    }

    public static double lerp(double delta, double start, double end) {
        return start + delta * (end - start);
    }

    public static double lerp2(double deltaX, double deltaY, double x0y0, double x0y1, double x1y0, double x1y1) {
        return lerp(deltaY, lerp(deltaX, x0y0, x0y1), lerp(deltaX, x1y0, x1y1));
    }

    public static double lerp3(double deltaX, double deltaY, double deltaZ, double x0y0z0, double x0y1z0, double x1y0z0, double x1y1z0, double x0y0z1, double x0y1z1, double x1y0z1, double x1y1z1) {
        return lerp(deltaZ, lerp2(deltaX, deltaY, x0y0z0, x0y1z0, x1y0z0, x1y1z0), lerp2(deltaX, deltaY, x0y0z1, x0y1z1, x1y0z1, x1y1z1));
    }

    public static double cerp(double delta, double y0,double y1, double y2,double y3) {
        double delta2 = delta * delta;
        double a0 = -0.5 * y0 + 1.5 * y1 - 1.5 * y2 + 0.5 * y3;
        double a1 = y0 - 2.5 * y1 + 2 * y2 - 0.5 * y3;
        double a2 = -0.5 * y0 + 0.5 * y2;
        double a3 = y1;

        return(a0 * delta * delta2 + a1 * delta2 + a2 * delta + a3);
    }

    public static double sigmoid(double val, double startStrength, double falloffStrength, double max) {
        return max / (Math.exp(startStrength - val / falloffStrength) + 1);
    }
}

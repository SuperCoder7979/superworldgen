package supercoder79.superworldgen.math;

import supercoder79.superworldgen.function.NoiseSampler2D;
import supercoder79.superworldgen.function.NoiseSampler3D;

public class CalculusUtil {
    private static final double CONST = 0.1;

    public static double derivative(NoiseSampler2D sampler, double x, double z) {
        double baseSample = sampler.sample(x, z);

        double xVal1 = (sampler.sample(x + CONST, z) - baseSample) / CONST;
        double xVal2 = (sampler.sample(x - CONST, z) - baseSample) / CONST;
        double zVal1 = (sampler.sample(x, z + CONST) - baseSample) / CONST;
        double zVal2 = (sampler.sample(x, z - CONST) - baseSample) / CONST;

        return Math.sqrt(((xVal2 - xVal1) * (xVal2 - xVal1)) + ((zVal2 - zVal1) * (zVal2 - zVal1)));
    }

    public static double derivative(NoiseSampler3D sampler, double x, double y, double z) {
        double baseSample = sampler.sample(x, y, z);

        double xVal1 = (sampler.sample(x + CONST, y, z) - baseSample) / CONST;
        double xVal2 = (sampler.sample(x - CONST, y, z) - baseSample) / CONST;
        double zVal1 = (sampler.sample(x, y, z + CONST) - baseSample) / CONST;
        double zVal2 = (sampler.sample(x, y, z - CONST) - baseSample) / CONST;
        double yVal1 = (sampler.sample(x, y + CONST, z) - baseSample) / CONST;
        double yVal2 = (sampler.sample(x, y - CONST, z) - baseSample) / CONST;

        return Math.sqrt(((xVal2 - xVal1) * (xVal2 - xVal1)) + ((zVal2 - zVal1) * (zVal2 - zVal1)) + ((yVal2 - yVal1) * (yVal2 - yVal1)));
    }
}

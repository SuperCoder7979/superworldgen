package supercoder79.superworldgen.function;

@FunctionalInterface
public interface NoiseSampler3D {
    double sample(double x, double y, double z);
}

package integration.methods.simpson;

import integration.methods.IntegrationMethod;

import java.util.function.Function;

public class SimpsonMethod implements IntegrationMethod {

    @Override
    public double solve(Function<Double, Double> fx, double a, double b) {
        return (b - a) / 6 * (fx.apply(a) + 4 * fx.apply((a + b) / 2) + fx.apply(b));
    }

    @Override
    public String toString() {
        return "Simpson method";
    }
}

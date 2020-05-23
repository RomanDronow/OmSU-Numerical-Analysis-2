package integration.methods.rectangles;

import integration.methods.IntegrationMethod;
import integration.util.Util;

import java.util.function.Function;

public class LeftEndpointMethod implements IntegrationMethod {
    @Override
    public double solve(Function<Double, Double> fx, double a, double b) {
        double n = Util.getSteps();
        double h = (b - a) / n;
        double integral = 0;
        for (double i = a; i < b; i += h) {
            integral += h * fx.apply(i);

        }
        return integral;
    }

    @Override
    public String toString() {
        return "Left endpoint method";
    }
}

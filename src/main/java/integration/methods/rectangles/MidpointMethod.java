package integration.methods.rectangles;

import integration.methods.IntegrationMethod;
import integration.util.Util;

import java.util.function.Function;

public class MidpointMethod implements IntegrationMethod {
    @Override
    public double solve(Function<Double, Double> fx, double a, double b) {
        double n = Util.getSteps();
        double EPS = Util.getEPS();
        double h = (b - a) / n;
        double integral = 0;
        for (double i = a + h; i-EPS <= b; i += h) {
            integral += fx.apply(((i - h) + i) / 2) * (i - (i - h));
        }
        return integral;
    }

    @Override
    public String toString() {
        return "Midpoint method";
    }
}

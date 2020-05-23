package integration.methods.gauss;

import integration.methods.IntegrationMethod;

import java.util.function.Function;
public class GaussMethod implements IntegrationMethod {
    @Override
    public double solve(Function<Double, Double> fx, double a, double b) {
        double a1 = (b-a)/2;
        double a2 = (b - a) / (2 * Math.sqrt(3));
        double a3 = fx.apply(((a+b)/2) - a2);
        double a4 = fx.apply(((a+b)/2) + a2);
        return a1 * (a3+a4);
    }

    @Override
    public String toString() {
        return "Gauss Method";
    }
}

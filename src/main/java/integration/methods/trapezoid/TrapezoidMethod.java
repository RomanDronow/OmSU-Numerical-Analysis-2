package integration.methods.trapezoid;

import integration.methods.IntegrationMethod;
import integration.util.Util;

import java.util.function.Function;

public class TrapezoidMethod implements IntegrationMethod {
    @Override
    public double solve(Function<Double, Double> fx, double a, double b) {
        double n = Util.getSteps();
        double EPS = Util.getEPS();
        double h = (b - a) / n;
        double integral = 0;
        for (double i = a; i-EPS < b - h; i += h) {
            integral += h * ((fx.apply(i) + fx.apply(i + h)) / 2);
        }
        return integral;
    }

    public double solve(Function<Double,Double> fx, double a, double b, int steps){
        double EPS = Util.getEPS();
        double h = (b - a) / steps;
        double integral = 0;
        for (double i = a; i-EPS < b - h; i += h) {
            integral += h * ((fx.apply(i) + fx.apply(i + h)) / 2);
        }
        return integral;
    }

    @Override
    public String toString() {
        return "Trapezoid method";
    }
}

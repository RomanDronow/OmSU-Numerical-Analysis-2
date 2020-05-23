package integration.solver;

import integration.methods.IntegrationMethod;
import integration.methods.trapezoid.TrapezoidMethod;

import java.util.function.Function;

import static slae.GaussianElimination.lsolve;

public class Solver {
    public static double[] calculate(Function<Double, Double> phi0, Function<Double, Double> phi1, Function<Double, Double> fx, IntegrationMethod method, double a, double b) {
        double g11 = method.solve(x -> (phi1.apply(x) * phi1.apply(x)), a, b);
        double g01 = method.solve(x -> (phi0.apply(x) * phi1.apply(x)), a, b);
        double g00 = method.solve(x -> (phi0.apply(x) * phi0.apply(x)), a, b);
        double f0 = method.solve(x -> (phi0.apply(x) * fx.apply(x)), a, b);
        double f1 = method.solve(x -> (phi1.apply(x) * fx.apply(x)), a, b);
        double[][] G = {{g00, g01}, {g01, g11}};
        double[] f = {f0, f1};
        return lsolve(G,f);
    }

    public static double[] calculate(Function<Double, Double> phi0, Function<Double, Double> phi1, Function<Double, Double> fx, TrapezoidMethod method, double a, double b, int steps) {
        double g11 = method.solve(x -> (phi1.apply(x) * phi1.apply(x)), a, b, steps);
        double g01 = method.solve(x -> (phi0.apply(x) * phi1.apply(x)), a, b, steps);
        double g00 = method.solve(x -> (phi0.apply(x) * phi0.apply(x)), a, b, steps);
        double f0 = method.solve(x -> (phi0.apply(x) * fx.apply(x)), a, b, steps);
        double f1 = method.solve(x -> (phi1.apply(x) * fx.apply(x)), a, b, steps);
        double[][] G = {{g00, g01}, {g01, g11}};
        double[] f = {f0, f1};
        return lsolve(G,f);
    }
}

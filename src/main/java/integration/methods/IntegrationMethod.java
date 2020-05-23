package integration.methods;

import java.util.function.Function;

public interface IntegrationMethod {
    double solve(Function<Double, Double> fx, double a, double b);
}
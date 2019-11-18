package integration.methods;

import integration.function.IntegralFunction;

public interface IntegrationMethod {
    float solve(IntegralFunction fx, float a, float b);
}
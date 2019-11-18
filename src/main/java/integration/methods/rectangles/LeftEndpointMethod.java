package integration.methods.rectangles;

import integration.function.IntegralFunction;
import integration.methods.IntegrationMethod;
import integration.util.Util;

import java.text.DecimalFormat;

public class LeftEndpointMethod implements IntegrationMethod {
    @Override
    public float solve(IntegralFunction fx, float a, float b) {
        float n = Util.getSteps();
        float h = (b - a) / n;
        float integral = 0;
        for (float i = a; i < b; i += h) {
            integral += h * fx.apply(i);

        }
        return integral;
    }

    @Override
    public String toString() {
        return "Left endpoint method";
    }
}

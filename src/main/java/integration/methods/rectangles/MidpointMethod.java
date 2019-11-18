package integration.methods.rectangles;

import integration.function.IntegralFunction;
import integration.methods.IntegrationMethod;
import integration.util.Util;

public class MidpointMethod implements IntegrationMethod {
    @Override
    public float solve(IntegralFunction fx, float a, float b) {
        float n = Util.getSteps();
        float EPS = Util.getEPS();
        float h = (b - a) / n;
        float integral = 0;
        for (float i = a + h; i-EPS <= b; i += h) {
            integral += fx.apply(((i - h) + i) / 2) * (i - (i - h));
        }
        return integral;
    }

    @Override
    public String toString() {
        return "Midpoint method";
    }
}

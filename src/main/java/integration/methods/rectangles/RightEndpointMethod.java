package integration.methods.rectangles;

import integration.function.IntegralFunction;
import integration.methods.IntegrationMethod;
import integration.util.Util;

public class RightEndpointMethod implements IntegrationMethod {
    @Override
    public float solve(IntegralFunction fx, float a, float b) {
        float n = Util.getSteps();
        float EPS = Util.getEPS();
        float h = (b - a) / n;
        float integral = 0;
        for (float i = a + h; i-EPS <= b; i += h) {
            System.out.println(i);
            integral += h * fx.apply(i);
        }
        return integral;
    }

    @Override
    public String toString() {
        return "Right endpoint method";
    }
}

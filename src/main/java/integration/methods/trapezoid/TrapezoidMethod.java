package integration.methods.trapezoid;

import integration.function.IntegralFunction;
import integration.methods.IntegrationMethod;
import integration.util.Util;

public class TrapezoidMethod implements IntegrationMethod {
    @Override
    public float solve(IntegralFunction fx, float a, float b) {
        float n = Util.getSteps();
        float EPS = Util.getEPS();
        float h = (b - a) / n;
        float integral = 0;
        for (float i = a; i-EPS < b - h; i += h) {
            integral += h * ((fx.apply(i) + fx.apply(i + h)) / 2);
        }
        return integral;
    }

    @Override
    public String toString() {
        return "Trapezoid method";
    }
}

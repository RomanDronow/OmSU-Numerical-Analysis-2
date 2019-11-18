package integration.main;

import integration.function.IntegralFunction;
import integration.methods.IntegrationMethod;
import integration.methods.rectangles.*;
import integration.methods.simpsons.SimpsonsMethod;
import integration.methods.trapezoid.TrapezoidMethod;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IntegralFunction fx = (x -> 1 / (Math.pow(x, 2)));
        float a = 1, b = 2;
        List<IntegrationMethod> methods = new ArrayList<IntegrationMethod>();
        methods.add(new LeftEndpointMethod());
        methods.add(new RightEndpointMethod());
        methods.add(new MidpointMethod());
        methods.add(new TrapezoidMethod());
        methods.add(new SimpsonsMethod());
        for (IntegrationMethod m : methods) {
            System.out.println(m + ": " + m.solve(fx, a, b));
        }
    }
}

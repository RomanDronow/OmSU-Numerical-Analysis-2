package integration.main;

import integration.methods.IntegrationMethod;
import integration.methods.gauss.GaussMethod;
import integration.methods.rectangles.LeftEndpointMethod;
import integration.methods.rectangles.MidpointMethod;
import integration.methods.rectangles.RightEndpointMethod;
import integration.methods.simpson.SimpsonMethod;
import integration.methods.trapezoid.TrapezoidMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

import static integration.solver.Solver.calculate;
import static integration.util.Util.otklonenie;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Function<Double, Double> phi0 = (x -> 1.);
        Function<Double, Double> phi1 = (x -> pow(x,2));
        Function<Double, Double> fx = (x -> pow(x,2)+1);
        ArrayList<IntegrationMethod> methods = createMethods();
        double a = 0, b = 1;
        for (IntegrationMethod method : methods) {
            double[] x = calculate(phi0, phi1, fx, method, a, b);
            System.out.println(Arrays.toString(x));
            System.out.println("otklonenie = " + otklonenie(phi0, phi1, fx, a, b, 0.01, x));
        }
    }

    private static ArrayList<IntegrationMethod> createMethods() {
        ArrayList<IntegrationMethod> methods = new ArrayList<>();
//        methods.add(new LeftEndpointMethod());
//        methods.add(new RightEndpointMethod());
//        methods.add(new MidpointMethod());
        methods.add(new TrapezoidMethod());
//        methods.add(new GaussMethod());
//        methods.add(new SimpsonMethod());
        return methods;
    }
}

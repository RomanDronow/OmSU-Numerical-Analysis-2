package integration.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Util {
    public static double getSteps() {
//        return 1e1;
//        return 1e2;
//        return 1e3;
//        return 1e4;
//        return 1e5;
        return 1e6;
//        return 1e7;
    }

    public static double getEPS() {
        return 1e-6;
    }

    public static double otklonenie(Function<Double, Double> phi0, Function<Double, Double> phi1, Function<Double, Double> fx, double a, double b, double h, double[] as) {
        double a0 = as[0];
        double a1 = as[1];
        ArrayList<Double> evasions = new ArrayList<Double>();
        for (double d = a; d <= b; d += h) {
            evasions.add(Math.abs(fx.apply(d) - (phi0.apply(d) * a0 + phi1.apply(d) * a1)));
        }
        return Collections.max(evasions);
    }
}

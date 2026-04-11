package org.example.chapter03.figures;

public final class AreaUtil {
    private AreaUtil() {}

    public static double averageArea(AreaMeasurable[] figures) {
        if (figures == null || figures.length == 0) return 0;
        double sum = 0;
        for (AreaMeasurable f : figures) {
            sum += f.getArea();
        }
        return sum / figures.length;
    }
}

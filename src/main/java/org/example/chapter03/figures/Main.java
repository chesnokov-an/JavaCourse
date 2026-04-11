package org.example.chapter03.figures;

public class Main {
    static void main() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(0, 4);
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.printf("Площадь треугольника:\t %.3f\n", triangle.getArea());

        Sphere sphere = new Sphere(new Point(0, 0), 5);
        System.out.printf("Площадь сферы:\t\t\t %.3f\n", sphere.getArea());

        double avg = AreaUtil.averageArea(triangle, sphere);
        System.out.printf("Средняя площадь:\t\t %.3f\n", avg);
    }
}

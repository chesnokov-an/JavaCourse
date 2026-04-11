package org.example.chapter03.figures;

public final class Sphere implements AreaMeasurable{
    private final Point centre;
    private final double radius;

    public Sphere(Point centre, double radius){
        if (radius < 0) throw new IllegalArgumentException("Radius cannot be negative");
        this.centre = centre;
        this.radius = radius;
    }

    Point getCentre(){ return centre; }
    double getRadius(){ return radius; }

    @Override
    public double getArea(){
        return 4 * Math.PI * radius * radius;
    }
}

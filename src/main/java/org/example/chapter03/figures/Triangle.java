package org.example.chapter03.figures;

public final class Triangle implements AreaMeasurable{
    private final Point a;
    private final Point b;
    private final Point c;

    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() { return a; }
    public Point getB() { return b; }
    public Point getC() { return c; }

    @Override
    public double getArea() {
        double ab = Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
        double bc = Math.hypot(b.getX() - c.getX(), b.getY() - c.getY());
        double ca = Math.hypot(c.getX() - a.getX(), c.getY() - a.getY());
        double p = (ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }
}

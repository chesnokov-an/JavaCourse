package org.example.chapter02.task05;

public final class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point translate(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    static void main() {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p.getX() + " " + p.getY());
    }
}

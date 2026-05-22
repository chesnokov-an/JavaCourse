package org.example.chapter04.task02.shape;

import org.example.chapter04.task01.point.Point;

public class Circle extends Shape{
    private double radius;
    public Circle(Point center, double radius){
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter(){
        return point;
    }

    public double getRadius(){ return radius; }

    @Override
    public Circle clone() throws CloneNotSupportedException{
        return (Circle)super.clone();
    }
}
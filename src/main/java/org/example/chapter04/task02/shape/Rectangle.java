package org.example.chapter04.task02.shape;

import org.example.chapter04.task01.point.Point;

public class Rectangle extends Shape{
    private double width, height;
    public Rectangle (Point topLeft, double width, double height){
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter(){
        return new Point(point.getX() + width/2, point.getX() + width/2);
    }

    public double getWidth(){ return width; }
    public double getHeight(){ return height; }

    @Override
    public Rectangle clone() throws CloneNotSupportedException{
        return (Rectangle)super.clone();
    }
}

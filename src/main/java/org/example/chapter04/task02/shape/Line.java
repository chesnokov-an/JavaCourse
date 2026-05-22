package org.example.chapter04.task02.shape;

import org.example.chapter04.task01.point.Point;

public class Line extends Shape{
    private Point to;
    public Line(Point from, Point to){
        super(from);
        this.to = to;
    }

    @Override
    public void moveBy(double dx, double dy){
        super.moveBy(dx, dy);
        to = new Point(to.getX() + dx, to.getY() + dy);
    }

    @Override
    public Point getCenter(){
        return new Point((point.getX() + to.getX()) / 2, (point.getY() + to.getY()) / 2);
    }

    public Point getTo(){ return to; }

    @Override
    public Line clone() throws CloneNotSupportedException{
        Line cloned = (Line)super.clone();
        cloned.to = new Point(this.to.getX(), this.to.getY());
        return cloned;
    }
}

package org.example.chapter04.task01;

import java.util.Objects;

public class Point{
    private double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){ return x; }
    public double getY(){ return y; }

    @Override public String toString(){
        return getClass().getName() + ", x = " + x + ", y = " + y;
    }
    @Override public boolean equals(Object other){
        if(this == other) return true;
        if(other == null) return false;
        if(getClass() != other.getClass()) return false;
        Point p = (Point) other;
        return x == p.x && y == p.y;
    }
    @Override public int hashCode(){
        return Objects.hash(x, y);
    }
}


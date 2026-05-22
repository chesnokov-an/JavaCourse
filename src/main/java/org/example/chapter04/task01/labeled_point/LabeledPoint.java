package org.example.chapter04.task01.labeled_point;

import org.example.chapter04.task01.point.Point;

import java.util.Objects;

public class LabeledPoint extends Point{
    private String label;
    public LabeledPoint(String label, double x, double y){
        super(x, y);
        this.label = label;
    }
    public String getLabel(){ return label; }

    // Метод для демонстрации защищённого доступа
    public void printCoordinates(Point p){
        System.out.println("this.x = " + x + ", this.y = " + y);
//        System.out.println(p.x); // ошибка компиляции, т.к. поял protected, а мы в другом пакете
    }

    @Override public String toString(){
        return super.toString() + ", label = " + label;
    }
    @Override public boolean equals(Object other){
        if (!super.equals(other)) return false;
        LabeledPoint lp = (LabeledPoint) other;
        return Objects.equals(label, lp.label);
    }
    @Override public int hashCode(){
        return Objects.hash(super.hashCode(), label);
    }

    static void main() {
        LabeledPoint lp1 = new LabeledPoint("A", 1, 2);
        LabeledPoint lp2 = new LabeledPoint("A", 1, 2);
        LabeledPoint lp3 = new LabeledPoint("B", 1, 2);
        Point p1 = new Point(1, 2);
        System.out.println("lp1.equals(lp2): " + lp1.equals(lp2));
        System.out.println("lp1.equals(lp3): " + lp1.equals(lp3));
        System.out.println("lp1: " + lp1);

        lp1.printCoordinates(p1);
    }
}

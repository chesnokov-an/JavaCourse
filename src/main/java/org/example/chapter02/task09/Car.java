package org.example.chapter02.task09;

public class Car {
    private final double fuelConsumption;
    private double fuel;
    private double totalDistance;
    private double x;
    private double y;

    public Car(double fuelConsumption) {
        if (fuelConsumption <= 0) {
            throw new IllegalArgumentException("Расход топлива должен быть положительным");
        }
        this.fuelConsumption = fuelConsumption;
        this.fuel = 0;
        this.totalDistance = 0;
        this.x = 0;
        this.y = 0;
    }

    public double getFuelLevel() {
        return fuel;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void fill(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Количество топлива должно быть положительным");
        }
        fuel += liters;
    }

    public void move(double dx, double dy) {
        double distance = Math.hypot(dx, dy); // длина вектора перемещения
        if (distance == 0) return;
        double neededFuel = distance / fuelConsumption;
        if (fuel < neededFuel) {
            throw new IllegalStateException("Недостаточно топлива");
        }
        fuel -= neededFuel;
        totalDistance += distance;
        x += dx;
        y += dy;
    }

    public double maxDistance() {
        return fuel * fuelConsumption;
    }

    public static void main(String[] args) {
        Car myCar = new Car(10);
        myCar.fill(20);
        System.out.println("Топливо: " + myCar.getFuelLevel() + ", пробег: " + myCar.getTotalDistance() +
                ", координаты: (" + myCar.getX() + ", " + myCar.getY() + ")");
        myCar.move(30, 40); // расстояние 50 км
        System.out.println("После move(30,40): топливо " + myCar.getFuelLevel() + ", пробег " + myCar.getTotalDistance() +
                ", координаты: (" + myCar.getX() + ", " + myCar.getY() + ")");
        myCar.move(-10, 0);
        System.out.println("После move(-10,0): топливо " + myCar.getFuelLevel() + ", пробег " + myCar.getTotalDistance() +
                ", координаты: (" + myCar.getX() + ", " + myCar.getY() + ")");
        System.out.println("Ещё может проехать: " + myCar.maxDistance());
    }
}
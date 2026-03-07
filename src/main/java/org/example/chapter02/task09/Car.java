package org.example.chapter02.task09;

public class Car {
    private final double fuelConsumption;
    private double fuel;
    private double distance;

    public Car(double fuelConsumption) {
        if (fuelConsumption <= 0) {
            throw new IllegalArgumentException("Расход топлива должен быть положительным");
        }
        this.fuelConsumption = fuelConsumption;
        fuel = 0;
        distance = 0;
    }

    public double getFuelLevel() {
        return fuel;
    }

    public double getDistance() {
        return distance;
    }

    public void fill(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Количество топлива должно быть положительным");
        }
        fuel += liters;
    }

    public void drive(double km) {
        if (km <= 0) {
            throw new IllegalArgumentException("Расстояние должно быть положительным");
        }
        double neededFuel = km / fuelConsumption;
        if (fuel < neededFuel) {
            throw new IllegalStateException("Недостаточно топлива");
        }
        fuel -= neededFuel;
        distance += km;
    }

    public double maxDistance() {
        return fuel * fuelConsumption;
    }

    static void main() {
        Car myCar = new Car(10);
        myCar.fill(20);
        System.out.println("Топливо: " + myCar.getFuelLevel() + ", пробег: " + myCar.getDistance());
        myCar.drive(50);
        System.out.println("После 50 км: топливо " + myCar.getFuelLevel() + ", пробег " + myCar.getDistance());
        myCar.drive(100);
        System.out.println("После ещё 100 км: топливо " + myCar.getFuelLevel() + ", пробег " + myCar.getDistance());
        System.out.println("Ещё может проехать: " + myCar.maxDistance());
    }
}

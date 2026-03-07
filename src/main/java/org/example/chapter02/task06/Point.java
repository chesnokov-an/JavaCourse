package org.example.chapter02.task06;

/**
 * Представляет изменяемую точку на плоскости с координатами x и y.
 * Методы {@link #translate(double, double)} и {@link #scale(double)}
 * изменяют состояние текущего объекта и возвращают его же для организации цепочек вызовов.
 *
 * @author Ваше Имя
 * @version 1.0
 */
public class Point {
    private double x;
    private double y;

    /**
     * Создаёт точку с заданными координатами.
     *
     * @param x координата x
     * @param y координата y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Создаёт точку в начале координат (0, 0).
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Возвращает координату x этой точки.
     *
     * @return координата x
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату y этой точки.
     *
     * @return координата y
     */
    public double getY() {
        return y;
    }

    /**
     * Смещает точку на заданные расстояния.
     * Метод изменяет текущий объект и возвращает ссылку на него для цепочечных вызовов.
     *
     * @param dx смещение по оси x
     * @param dy смещение по оси y
     * @return этот объект Point после смещения
     */
    public Point translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    /**
     * Масштабирует координаты точки на заданный коэффициент.
     * Метод изменяет текущий объект и возвращает ссылку на него для цепочечных вызовов.
     *
     * @param factor коэффициент масштабирования
     * @return этот объект Point после масштабирования
     */
    public Point scale(double factor) {
        this.x *= factor;
        this.y *= factor;
        return this;
    }

    static void main() {
        Point p = new Point(3, 4);
        p.translate(1, 3).scale(0.5);
        System.out.println(p.getX() + " " + p.getY());
    }
}

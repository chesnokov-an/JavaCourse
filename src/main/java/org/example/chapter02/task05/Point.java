package org.example.chapter02.task05;

/**
 * Представляет неизменяемую точку на плоскости с координатами x и y.
 * Все операции преобразования создают новый объект, не изменяя существующий.
 *
 * @author chesnokov-an
 * @version 1.0
 */
public final class Point {
    private final double x;
    private final double y;

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
     * Создаёт новую точку, смещённую относительно текущей на заданные расстояния.
     *
     * @param dx смещение по оси x
     * @param dy смещение по оси y
     * @return новая точка с координатами (x + dx, y + dy)
     */
    public Point translate(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    /**
     * Создаёт новую точку, координаты которой умножены на заданный коэффициент.
     *
     * @param factor коэффициент масштабирования
     * @return новая точка с координатами (x * factor, y * factor)
     */
    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    static void main() {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p.getX() + " " + p.getY());
    }
}

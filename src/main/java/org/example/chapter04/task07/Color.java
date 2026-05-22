package org.example.chapter04.task07;

public enum Color {
    BLACK   (0, 0, 0),
    RED     (255, 0, 0),
    BLUE    (0, 0, 255),
    GREEN   (0, 255, 0),
    CYAN    (0, 255, 255),
    MAGENTA (255, 0, 255),
    YELLOW  (255, 255, 0),
    WHITE   (255, 255, 255);

    private int red, green, blue;

    Color(int r, int g, int b) {
        red = r; green = g; blue = b;
    }

    public int getRed()   { return red; }
    public int getGreen() { return green; }
    public int getBlue()  { return blue; }
}

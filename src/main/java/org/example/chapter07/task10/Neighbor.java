package org.example.chapter07.task10;

public record Neighbor(String name, int distance) implements Comparable<Neighbor> {
    @Override
    public int compareTo(Neighbor other) {
        return Integer.compare(distance, other.distance);
    }
}

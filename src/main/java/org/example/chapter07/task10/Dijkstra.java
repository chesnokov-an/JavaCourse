package org.example.chapter07.task10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Dijkstra {
    public record Paths(Map<String, Integer> distances, Map<String, String> previous) {
        public int distanceTo(String city) {
            return distances.getOrDefault(city, Integer.MAX_VALUE);
        }

        public List<String> pathTo(String city) {
            LinkedList<String> path = new LinkedList<>();
            for (String at = city; at != null; at = previous.get(at)) {
                path.addFirst(at);
            }
            return path;
        }
    }

    public static Paths shortestPaths(Map<String, Set<Neighbor>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        for (String city : graph.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Neighbor> queue = new PriorityQueue<>();
        queue.add(new Neighbor(start, 0));

        while (!queue.isEmpty()) {
            Neighbor current = queue.remove();

            // В очереди могли остаться устаревшие записи с большим расстоянием
            if (current.distance() > distances.get(current.name())) {
                continue;
            }

            for (Neighbor neighbor : graph.getOrDefault(current.name(), Set.of())) {
                int newDistance = current.distance() + neighbor.distance();
                if (newDistance < distances.getOrDefault(neighbor.name(), Integer.MAX_VALUE)) {
                    distances.put(neighbor.name(), newDistance);
                    previous.put(neighbor.name(), current.name());
                    queue.add(new Neighbor(neighbor.name(), newDistance));
                }
            }
        }
        return new Paths(distances, previous);
    }

    public static void connect(Map<String, Set<Neighbor>> graph, String from, String to, int distance) {
        graph.computeIfAbsent(from, key -> new HashSet<>()).add(new Neighbor(to, distance));
        graph.computeIfAbsent(to, key -> new HashSet<>()).add(new Neighbor(from, distance));
    }

    static void main() {
        Map<String, Set<Neighbor>> roads = new HashMap<>();
        connect(roads, "Москва", "Тверь", 180);
        connect(roads, "Москва", "Владимир", 185);
        connect(roads, "Москва", "Рязань", 200);
        connect(roads, "Тверь", "Санкт-Петербург", 530);
        connect(roads, "Владимир", "Нижний Новгород", 225);
        connect(roads, "Нижний Новгород", "Казань", 390);
        connect(roads, "Рязань", "Казань", 620);

        Dijkstra.Paths paths = shortestPaths(roads, "Москва");

        System.out.println("Кратчайшие расстояния от Москвы:");
        for (Map.Entry<String, Integer> entry : new TreeMap<>(paths.distances()).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
        System.out.println("Маршрут до Казани: " + paths.pathTo("Казань")
                + ", расстояние " + paths.distanceTo("Казань"));
    }
}

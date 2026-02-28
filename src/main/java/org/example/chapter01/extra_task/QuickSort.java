package org.example.chapter01.extra_task;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> data){
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> pivotList = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();
        if(data.size() <= 1) return data;
        int pivot = data.get(data.size() / 2);
        for(int i : data){
            if(i < pivot)
                less.add(i);
            else if(i > pivot)
                more.add(i);
            else
                pivotList.add(i);
        }
        less = sort(less);
        more = sort(more);
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(less);
        res.addAll(pivotList);
        res.addAll(more);
        return res;
    }

    static void main() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> data = new ArrayList<>();
        String line = scanner.nextLine();
        if (line.isEmpty()) return;
        for (String str : line.split(" ")) {
            data.add(Integer.parseInt(str));
        }

        System.out.println(sort(data));
    }
}

package org.example.chapter01.task14;

import java.util.ArrayList;
import java.util.Scanner;

public class Task14 {
    static ArrayList<ArrayList<Integer>> readSquare(Scanner scanner){
        ArrayList<ArrayList<Integer>> square = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            ArrayList<Integer> rowInt = new ArrayList<>();
            for (String str : line.split(" ")) {
                rowInt.add(Integer.parseInt(str));
            }
            square.add(rowInt);
        }
        return square;
    }

    static boolean squareChecker(ArrayList<ArrayList<Integer>> square){
        int columnCount = square.size();
        for(ArrayList<Integer> row : square){
            if(row.size() != columnCount)
                return false;
        }
        return true;
    }

    static boolean magicChecker(ArrayList<ArrayList<Integer>> square){
        int firstSum = square.getFirst().stream().mapToInt(Integer::intValue).sum();
        for(ArrayList<Integer> row : square){
            if(row.stream().mapToInt(Integer::intValue).sum() != firstSum)
                return false;
        }

        for(int i = 0; i < square.size(); i++){
            int currentColSum = 0;
            for (ArrayList<Integer> integers : square) {
                currentColSum += integers.get(i);
            }
            if(currentColSum != firstSum)
                return false;
        }

        int mainDiagonalSum = 0;
        for(int i = 0; i < square.size(); i++){
            mainDiagonalSum += square.get(i).get(i);
        }
        if(mainDiagonalSum != firstSum)
            return false;

        int sideDiagSum = 0;
        for(int i = 0; i < square.size(); i++){
            sideDiagSum += square.get(i).get(square.size() - i - 1);
        }
        return sideDiagSum == firstSum;
    }

    static void main() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> square = readSquare(scanner);
        if(!squareChecker(square)){
            System.out.println("Incorrect input");
            return;
        }
        System.out.println((magicChecker(square)) ? ("Magic") : ("Not magic"));
    }
}

// 16 3 2 13
// 5 10 11 8
// 9 6 7 12
// 4 15 14 1
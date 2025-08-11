package DP;
// COMPLETED

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    static void helper(int currRow, int totalRows, List<List<Integer>> result){
        if(currRow > totalRows) return;

        List<Integer> lastRow = result.get(result.size()-1);
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < currRow; i++) {
            if(i == 0 || i == currRow-1){
                row.add(1);
            }
            else {
                row.add(lastRow.get(i - 1) + lastRow.get(i));
            }
        }

        result.add(row);
        helper(currRow+1, totalRows, result);
    }
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        helper(2, numRows, result);


        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

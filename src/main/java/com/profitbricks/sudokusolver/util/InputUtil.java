package com.profitbricks.sudokusolver.util;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class InputUtil {
    public static int[][] convertStringArrayTo2DIntArray(String[] input) {
        int[][] arr = new int[9][9];
        PrimitiveIterator.OfInt iterator = Arrays.stream(input).mapToInt(value -> {
            if (value.equals("x")) {
                return 0;
            } else {
                return Integer.parseInt(value);
            }
        }).iterator();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = iterator.next();
            }
        }
        return arr;
    }

}

package com.example.demo_productpage.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyAlgorithms {

    /**
     * @Description minimum value of Absolute Difference for two value
     */
    // Complete the minimumAbsoluteDifference function below.
    // static int minimumAbsoluteDifference(int[] arr) {
    //     int min = 0;

    //     Arrays.sort(arr);
    //     for(int i = 0; i < arr.length; i++) {
    //         if(i != arr.length-1) {
    //             int temp = Math.abs(arr[i] - arr[i+1]);
    //             if(i == 0) min = temp;
    //             else if(temp < min) min = temp;
    //             System.out.println(min);
    //         }
    //     }
    //     return min;
    // }

    // private static final Scanner scanner = new Scanner(System.in);

    // public static void main(String[] args) throws IOException {
    //     // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    //     int n = scanner.nextInt();
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     int[] arr = new int[n];

    //     String[] arrItems = scanner.nextLine().split(" ");
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     for (int i = 0; i < n; i++) {
    //         int arrItem = Integer.parseInt(arrItems[i]);
    //         arr[i] = arrItem;
    //     }

    //     int result = minimumAbsoluteDifference(arr);

    //     System.out.println(result);
    //     // bufferedWriter.write(String.valueOf(result));
    //     // bufferedWriter.newLine();

    //     // bufferedWriter.close();

    //     scanner.close();
    // }


    /**
     * @Description
     */
    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {

        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

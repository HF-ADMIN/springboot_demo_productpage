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
    // static long marcsCakewalk(int[] calorie) {

    //     return 1;
    // }

    // private static final Scanner scanner = new Scanner(System.in);

    // public static void main(String[] args) throws IOException {
    //     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    //     int n = scanner.nextInt();
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     int[] calorie = new int[n];

    //     String[] calorieItems = scanner.nextLine().split(" ");
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     for (int i = 0; i < n; i++) {
    //         int calorieItem = Integer.parseInt(calorieItems[i]);
    //         calorie[i] = calorieItem;
    //     }

    //     long result = marcsCakewalk(calorie);

    //     bufferedWriter.write(String.valueOf(result));
    //     bufferedWriter.newLine();

    //     bufferedWriter.close();

    //     scanner.close();
    // }


    /**
     * @Description 55533333 구하기 문제
     */

    // Complete the decentNumber function below.
    // static void decentNumber(int n) {
    //     StringBuffer outputString = new StringBuffer();

    //     int c = (n*2%3);
    //     if(n < c*5) outputString.append("-1");
    //     else {
    //         for(int i = 0; i < n- (5*c); i++) outputString.append("5");
    //         for(int i = 0; i < 5*c; i++) outputString.append("3");
    //     }
    //     System.out.println(outputString);
    // }


    /**
     * @Description 주어진 배열에서 4의 가중치를 두고 필요한 컨테이너의 갯수를 구하라
     */

    // Complete the toys function below.
    // static int toys(int[] w) {
    //     int conNum = 1;
        

    //     Arrays.sort(w);

    //     int temp = w[0];

    //     for(int i = 0; i < w.length; i++) {
    //         System.out.println("index i : " + i + ", conNum : " + conNum + ", add Con : " + w[i]);
    //         if(w[i] > temp+4) {
    //             conNum++;
    //             temp = w[i];
    //         }
    //     }
    //     return conNum;
    // }

    // private static final Scanner scanner = new Scanner(System.in);

    // public static void main(String[] args) throws IOException {


    //     int n = scanner.nextInt();
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     int[] w = new int[n];

    //     String[] wItems = scanner.nextLine().split(" ");
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     for (int i = 0; i < n; i++) {
    //         int wItem = Integer.parseInt(wItems[i]);
    //         w[i] = wItem;
    //     }

    //     int result = toys(w);

    //     scanner.close();

    //     System.out.println(result);
    // }
}

package com.example.demo_productpage.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DictionariesHashmaps {

/**
 * @Description HashMap을 이용한 Keyword 제거. HashMap의 Key는 Keyword, 그리고 Value는 Keyword 중복 갯 수.
 * @param magazine
 * @param note
 */
    
    // // Complete the checkMagazine function below.
    // static void checkMagazine(String[] magazine, String[] note) {
    //     Map<String, Integer> magazineMap = new HashMap<>();
    //     Map<String, Integer> noteMap = new HashMap<>();
    //     boolean yn = true;

    //     for(String s : magazine) {
    //         Integer num = magazineMap.get(s);

    //         if(num == null){
    //             magazineMap.put(s, 1);
    //         } else {
    //             magazineMap.put(s, num+1);
    //         }
    //     }

    //     for(String s : note) {
    //         Integer num = noteMap.get(s);

    //         if(num == null){
    //             noteMap.put(s, 1);
    //         } else {
    //             noteMap.put(s, num+1);
    //         }
    //     }

    //     for(String key : noteMap.keySet()) {
    //         if(!magazineMap.containsKey(key) || magazineMap.get(key) < noteMap.get(key)) {
    //             yn = false;
    //             break;
    //         }
    //     }

    //     if(yn) System.out.println("Yes");
    //     else System.out.println("No");

    // }

    // private static final Scanner scanner = new Scanner(System.in);

    // public static void main(String[] args) {
    //     String[] mn = scanner.nextLine().split(" ");

    //     int m = Integer.parseInt(mn[0]);

    //     int n = Integer.parseInt(mn[1]);

    //     String[] magazine = new String[m];

    //     String[] magazineItems = scanner.nextLine().split(" ");
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     for (int i = 0; i < m; i++) {
    //         String magazineItem = magazineItems[i];
    //         magazine[i] = magazineItem;
    //     }

    //     String[] note = new String[n];

    //     String[] noteItems = scanner.nextLine().split(" ");
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     for (int i = 0; i < n; i++) {
    //         String noteItem = noteItems[i];
    //         note[i] = noteItem;
    //     }

    //     checkMagazine(magazine, note);

    //     scanner.close();
    // }


/**
 * @Description 두 개의 문자열을 비교하여 중복이 되는 문자열이 있는지 검출하는 문제
 * @param s1
 * @param s2
 * @return
 */    
    // // Complete the twoStrings function below.
    // static String twoStrings(String s1, String s2) {
    //     Set<String> s1Set = new HashSet<>();
    //     Set<String> s2Set = new HashSet<>();
    //     Boolean yn = false;

    //     // s1 문자열을 나누어 HashSet에 저장하기
    //     for(int i = 0; i < s1.length(); i++){
    //         String s = s1.substring(i, i+1);
    //         s1Set.add(s);
    //     }

    //     // s2 문자열을 나누어 HashSet에 저장하기
    //     for(int i = 0; i < s2.length(); i++){
    //         String s = s2.substring(i, i+1);
    //         s2Set.add(s);
    //     }

    //     for(String s : s2Set) {
    //         if(s1Set.contains(s)) {
    //             yn = true;
    //             break;
    //         }
    //     }
        
    //     return yn ? "Yes":"No";
    // }

    // private static final Scanner scanner = new Scanner(System.in);

    // public static void main(String[] args) throws IOException {
    //     // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    //     int q = scanner.nextInt();
    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    //     for (int qItr = 0; qItr < q; qItr++) {
    //         String s1 = scanner.nextLine();

    //         String s2 = scanner.nextLine();

    //         String result = twoStrings(s1, s2);
    //         System.out.println(result);
    //         // bufferedWriter.write(result);
    //         // bufferedWriter.newLine();
    //     }

    //     // bufferedWriter.close();

    //     scanner.close();
    // }




}

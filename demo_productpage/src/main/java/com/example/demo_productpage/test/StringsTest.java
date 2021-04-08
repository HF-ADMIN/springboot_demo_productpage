package com.example.demo_productpage.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StringsTest {

    /**
     * @Description [Algorithms | Strings] Super Reduced String
     * @param s
     * @return
     */
    // Complete the superReducedString function below.
    static String superReducedString(String s) {

        outer:
        while (true) {
            for (int x = 0; x < s.length() - 1; x++) {
                if (s.charAt(x) == s.charAt(x + 1)) {
                    s = s.substring(0, x) + s.substring(x + 2, s.length());
                    continue outer;
                }
            }
            break;
        }
        return s.equals("") ? "Empty String" : s;
    }

    /**
     * @Description [Algorithms | Strings] camelcase
     */

    // Complete the camelcase function below.
    static int camelcase(String s) {
        int output = 1;

        for(int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) output ++;
        }
        return output;
    }

    /**
     * @Description [Algorithms | Strings] Strong Password
     * @param args
     * @throws IOException
     */
    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String[] input = password.split("(?!^)");

        String numbersString = "0123456789";
        String lower_caseString = "abcdefghijklmnopqrstuvwxyz";
        String upper_caseString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_charString = "!@#$%^&*()-+";

        String[] numbers = numbersString.split("(?!^)");
        String[] lower_case = lower_caseString.split("(?!^)");
        String[] upper_case = upper_caseString.split("(?!^)");
        String[] special_char = special_charString.split("(?!^)");

        List numbersList = Arrays.asList(numbers);
        List lowerList = Arrays.asList(lower_case);
        List upperList = Arrays.asList(upper_case);
        List specialList = Arrays.asList(special_char);

        Map<String, Integer> typeMap = new HashMap<>();
        Set<Integer> typeSet = new HashSet<>();

        for(String s : input) {
            if(numbersList.contains(s)) typeSet.add(1);
            if(lowerList.contains(s)) typeSet.add(2);
            if(upperList.contains(s)) typeSet.add(3);
            if(specialList.contains(s)) typeSet.add(4);
        }

        return Math.max((6-n), (4 - typeSet.size()));
    }


    /**
     * @Description [Algorithms | Strings] Caesar Cipher
     * @param args
     * @throws IOException
     */
    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        StringBuilder ab = new StringBuilder();
        char[] charArray = s.toCharArray();
        for(char c : charArray) {
            int temp = c + (k)%26;
            if(c >= "a".charAt(0) && c <= "z".charAt(0)) {    
                if(temp > 122) temp = 96 + (temp)%122;
                ab.append(Character.toString((char)temp));
            }else if(c >= "A".charAt(0) && c <= "Z".charAt(0)){
                if(temp > 90) temp = 64 + (temp)%90;
                ab.append(Character.toString((char)temp));
            }else {
                ab.append(Character.toString(c));
            }
        }
        return ab.toString();
    }

    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        System.out.println(result);

        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        bufferedReader.close();
        // bufferedWriter.close();
    }




}



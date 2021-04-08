package com.example.demo_productpage.test;

import java.util.HashMap;
import java.util.Map;

import com.example.demo_productpage.dto.ProductpageDTO;
import com.example.demo_productpage.dto.TInfoDTO;
import com.example.demo_productpage.repository.ProductpageRepository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TestCode01 {
    @Autowired
    public TInfoDTO getDto(String testData) {
        ProductpageDTO.Request request = new ProductpageDTO.Request();
        return request;
    }


    public static void main(String[] args) {
        // JSONObject jsonObject = new JSONObject();
        // JSONArray jsonArray = new JSONArray();
        // Map<Object, Object> tempMap = new HashMap<Object, Object>();
        
        // JSONObject jsonObject1 = new JSONObject();
        // // jsonObject1.put("key1-1", "value1-1");
        // // jsonObject1.put("key2", "value2");
        // tempMap.put("key1-1", "value1-1");
        // tempMap.put("key1-2", "value1-2");
        // jsonObject1.putAll(tempMap);

        // JSONObject jsonObject2 = new JSONObject();
        // tempMap.clear();
        // tempMap.put("key2-1", "value2-1");
        // tempMap.put("key2-2", "value2-2");
        // jsonObject2.putAll(tempMap);

        // jsonArray.add(jsonObject1);
        // jsonArray.add(jsonObject2);

        // jsonObject.put("detailList", jsonArray);
        // jsonObject.put("id", "1");

        // System.out.println("                        " + jsonObject);

        //----------------------------------------------------------------------------------

        // List<String> a = new ArrayList<>();
        // String b[] = {"1", "2", "3", "4", "5"};

        // a.addAll(Arrays.asList(b));

        // a.remove(0);

        // System.out.println(a.get(0));

        //----------------------------------------------------------------------------------

        String s = "!@#$%^&*()-+";

        String[] sb = s.split("(?!^)");
        System.out.println(Arrays.asList(sb).toString());
        System.out.println(sb.toString());

        Map<String, Integer> typeMap = new HashMap<>();

        typeMap.put("numbers", 1);
        typeMap.put("numbers", 1);
        typeMap.put("numbers", 1);
        typeMap.put("numbers", 1);

        System.out.println(typeMap.get("numbers"));

        //----------------------------------------------------------------------------------


        StringBuilder ab = new StringBuilder();
        String a = "www.abc.xy";
        // char aCh = (char) 99;
        char[] charArray = a.toCharArray();
        int k = 87;
        for(char c : charArray) {
            // 특문인 경우와 아닌 경우
            if(c >= "a".charAt(0) && c <= "z".charAt(0)) {
                // 소문자인 경우
                int temp = c + k;
                if(temp > 122) temp = 96 + (temp)%122;
                ab.append(Character.toString((char)temp));
                
            }else if(c >= "A".charAt(0) && c <= "Z".charAt(0)){
                int temp = c + k;
                if(temp > 90) temp = 64 + (temp)%90;
                ab.append(Character.toString((char)temp));
            }else {
                // 특수문자인 경우
                ab.append(Character.toString(c));
            }
        }

        System.out.println(ab);

        // System.out.println(aCh);


        //----------------------------------------------------------------------------------


        Map<String, Integer> map = new HashMap<>();

        map.put("S", 1);
        map.replace("S", map.get("S")+1);
        map.put("S", map.get("S") + 1);

        System.out.println(map.get("S"));

        String sample = "";





	}
}

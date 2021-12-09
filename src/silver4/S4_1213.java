package silver4;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S4_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = bf.readLine();
        String[] wordArr = word.split("");
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String s : wordArr) {
            if (map.keySet().contains(s)){
                map.put(s, map.get(s)+1);
            }
            else {
                map.put(s,1);
            }
        }
        int count =0;
        String middle = "";
        for (String s : map.keySet()){
            if (map.get(s)%2 != 0){
                count++;
                middle = s;
            }
        }
        if (count>1) {
            answer = "I'm Sorry Hansoo";
        }
        else if (count==1) {
            map.put(middle, map.get(middle)-1);
            String str = "";
            for (String key : map.keySet()){
                int num = map.get(key);
                for (int i=0; i< num/2; i++) {
                    str += key;
                }
            }
            String[] strArr = str.split("");
            Arrays.sort(strArr);
            for (String s : strArr) {
                answer += s;
            }
            answer += middle;
            for (int i=0; i<strArr.length; i++) {
                 answer += strArr[strArr.length-1-i];
            }
        }
        else {
            String str = "";
            for (String key : map.keySet()){
                int num = map.get(key);
                for (int i=0; i< num/2; i++) {
                    str += key;
                }
            }
            String[] strArr = str.split("");
            Arrays.sort(strArr);
            for (String s : strArr) {
                answer += s;
            }
            for (int i=0; i<strArr.length; i++) {
                answer += strArr[strArr.length-1-i];
            }
        }
        bw.write(answer);
        bw.close();
    }
}

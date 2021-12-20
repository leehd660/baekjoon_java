package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = bf.readLine();
        int lineNum = word.length();
        List<String> list = new ArrayList<>();

        for (int i = 1; i<lineNum-1; i++) {
            for (int j = 1; j<lineNum-i; j++) {
                String num1 = word.substring(0,i);
                String num2 = word.substring(i,i+j);
                String num3 = word.substring(i+j,lineNum);
                String changeWord = changeOrder(num1) + changeOrder(num2) + changeOrder(num3);
                list.add(changeWord);
            }
        }
        Collections.sort(list);
        bw.write(String.valueOf(list.get(0)));
        bw.close();
    }

    static String changeOrder(String str) {
        String[] arr = str.split("");
        String answer = "";
        for (int i=0; i< arr.length; i++) {
            answer += arr[arr.length-1-i];
        }
        return answer;
    }
}

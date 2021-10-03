package silver5;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = bf.readLine();
        Object[] numArr = num.split("");
        Arrays.sort(numArr, Collections.reverseOrder());
        for (Object s : numArr){
            bw.write(String.valueOf(s));
        }
        bw.close();
    }
}

package silver5;

import java.io.*;
import java.util.Arrays;

public class 삼십 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = bf.readLine();
        String[] numArr = num.split("");
        int total = 0;
        for (int i=0; i< numArr.length; i++){
            total += Integer.parseInt(numArr[i]);
        }
        if (!num.contains("0") || total%3!=0 ){
            bw.write("-1");
        }

        else {
            Arrays.sort(numArr);
            for (int i=numArr.length-1; i>=0; i--) {
                bw.write(numArr[i]);
            }
        }
        bw.close();
    }
}

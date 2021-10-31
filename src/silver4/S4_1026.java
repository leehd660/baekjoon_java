package silver4;

import java.io.*;
import java.util.Arrays;

public class S4_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String arrStr1 = bf.readLine();
        String arrStr2 = bf.readLine();
        String[] arr1 = arrStr1.split(" ");
        int[] arrNum1 = new int[num];
        for (int i=0; i<num; i++) {
            arrNum1[i] = Integer.parseInt(arr1[i]);
        }
        String[] arr2 = arrStr2.split(" ");
        int[] arrNum2 = new int[num];
        for (int i=0; i<num; i++) {
            arrNum2[i] = Integer.parseInt(arr2[i]);
        }
        Arrays.sort(arrNum1);
        Arrays.sort(arrNum2);
        int answer = 0;
        for (int i=0; i<num; i++) {
            answer += arrNum1[i]*arrNum2[num-1-i];
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
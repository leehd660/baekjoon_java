package silver5;

import java.io.*;
import java.util.Arrays;

public class N번째로큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++){
            String arrStr = bf.readLine();
            String[] arr = arrStr.split(" ");
            int[] numArr = new int[10];
            for (int j=0; j<10; j++){
                numArr[j] = Integer.parseInt(arr[j]);
            }
            Arrays.sort(numArr);
            bw.write(String.valueOf(numArr[7]) +'\n');
        }
        bw.close();
    }
}

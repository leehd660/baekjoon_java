package silver5;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int[] arr = new int[num];
        for (int i=0; i<num; i++){
            String a = bf.readLine();
            arr[i] = Integer.parseInt(a);
        }
        Arrays.sort(arr);
        for (int i:arr){
            String answer = String.valueOf(i);
            bw.write(answer+'\n');
        }
        bw.close();
    }
}

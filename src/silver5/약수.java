package silver5;

import java.io.*;
import java.util.Arrays;

public class 약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int answer = 0;
        String str = bf.readLine();

        if (num==1){
            answer = (int)Math.pow(Integer.parseInt(str),2);
        }
        else {
            String[] strArr = str.split(" ");
            int[] arr = new int[num];
            for (int i=0; i<num; i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            Arrays.sort(arr);
            answer = arr[0] * arr[num-1];
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

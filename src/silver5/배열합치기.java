package silver5;

import java.io.*;
import java.util.Arrays;

public class 배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sizeStr = bf.readLine();
        String[] size = sizeStr.split(" ");
        int a = Integer.parseInt(size[0]);
        int b = Integer.parseInt(size[1]);
        long[] arr = new long[a+b];
        String arr1Str = bf.readLine();
        String arr2Str = bf.readLine();
        String answer = arr1Str +" "+arr2Str;
        String[] arrStr = new String[a+b];
        arrStr = answer.split(" ");
        for (int i=0; i<a+b; i++){
            arr[i] = Long.parseLong(arrStr[i]);
        }
        Arrays.sort(arr);
        for (long i : arr) {
            bw.write(String.valueOf(i)+" ");
        }
        bw.close();
    }
}

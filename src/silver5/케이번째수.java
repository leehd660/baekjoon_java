package silver5;

import java.io.*;
import java.util.Arrays;

public class 케이번째수 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        long[] arr = new long[a];
//        for (int i=0; i<a; i++){
//            arr[i] = scanner.nextLong();
//        }
//        Arrays.sort(arr);
//        System.out.println(arr[b-1]);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        String[] strA = s.split(" ");
        int a = Integer.parseInt(strA[0]);
        int b = Integer.parseInt(strA[1]);
        String numStr = bf.readLine();
        String[] strArr = numStr.split(" ");
        long[] numArr = new long[a];
        for (int i=0; i<a; i++){
            numArr[i] = Long.parseLong(strArr[i]);
        }
        Arrays.sort(numArr);
        bw.write(String.valueOf(numArr[b-1]));
        bw.close();
    }
}

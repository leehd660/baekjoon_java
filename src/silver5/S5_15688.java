package silver5;

import java.io.*;
import java.util.*;

public class S5_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
//        int[] arr = new int[num];
        SortedMap<String, Integer> map = new TreeMap<>();
        for (int i=0; i<num; i++) {
            String numberStr = bf.readLine();
//            int number = Integer.parseInt(numberStr);
//            arr[i] = number;
            if (map.containsKey(numberStr)) {
                map.put(numberStr, map.get(numberStr)+1);
            }
            else {
                map.put(numberStr, 1);
            }
        }
//        Arrays.sort(arr);

        String answer = "";
//        for (int n : arr) {
//            bw.write(String.valueOf(n));
//        }
//        System.out.println(sb);
        bw.close();
    }
}

package bronze1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 피보나치수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        List<Long> arr = new ArrayList<>();
        arr.add((long)0);
        arr.add((long)1);
        while (num+1 >= arr.size()) {
            arr.add(arr.get(arr.size()-1)+arr.get(arr.size()-2));
        }
        bw.write(String.valueOf(arr.get(num)));
        bw.close();
    }
}

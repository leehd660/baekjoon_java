package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S4_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<num; i++) {
            String strNum = bf.readLine();
            int n = Integer.parseInt(strNum);
            if (n==0) {
                arr.remove(arr.size()-1);
            }
            else {
                arr.add(n);
            }
        }
        int answer =0;
        for (int i:arr){
            answer += i;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

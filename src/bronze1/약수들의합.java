package bronze1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 약수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String numStr = bf.readLine();
            int num = Integer.parseInt(numStr);
            if (num==-1){
                break;
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            int total = 1;
            for (int i=2; i<=Math.sqrt(num); i++){
                if (num%i==0){
                    arr.add(i);
                    arr.add(num/i);
                    total += i;
                    total += num/i;
                }
            }
            Collections.sort(arr);
            if (total == num){
                bw.write(String.valueOf(num) + " = ");
                for (int i=0; i<arr.size(); i++){
                    bw.write(String.valueOf(arr.get(i)));
                    if (i!=arr.size()-1){
                        bw.write(" + ");
                    }
                    else {
                        bw.write('\n');
                    }
                }
            }
            else {
                bw.write(String.valueOf(num) + " is NOT perfect."+'\n');
            }
        }
        bw.close();
    }
}

package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);

        List<Integer> arr = new ArrayList<>();
        while (true) {
            String test = check(num);
            if (!test.equals("finish")) {
                String[] testArr = test.split(" ");
                num = Integer.parseInt(testArr[0]);
                arr.add(Integer.parseInt(testArr[1]));
            }
            else {
                if (num!=1) {
                    arr.add(num);
                }
                break;
            }
        }
        Collections.sort(arr);
        for (int i:arr){
            bw.write(String.valueOf(i));
            bw.write("\n");
        }
        bw.close();
    }

    static String check(int num) {
        String answer = "";
        if (num%2 == 0) {
            answer = String.valueOf(num/2) + " " + String.valueOf(2);
        }
        else {
            for (int i=3; i<=Math.sqrt(num); i+=2) {
                if (num%i == 0) {
                    answer = String.valueOf(num/i) + " " + String.valueOf(i);
                    break;
                }
            }
        }
        if (answer.equals("")) {
            answer = "finish";
        }
        return answer;
    }
}

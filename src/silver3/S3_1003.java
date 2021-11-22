package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++) {
            List<int[]> fibonacci = new ArrayList<>();
            int[] arr0 = {1,0};
            int[] arr1 = {0,1};
            fibonacci.add(arr0);
            fibonacci.add(arr1);
            String findNumStr = bf.readLine();
            int findNum = Integer.parseInt(findNumStr);
            if (findNum == 0){
                bw.write(String.valueOf(fibonacci.get(0)[0]) + " " + String.valueOf(fibonacci.get(0)[1]) + "\n");
            }
            else if (findNum == 1){
                bw.write(String.valueOf(fibonacci.get(1)[0]) + " " + String.valueOf(fibonacci.get(1)[1]) + "\n");
            }
            else {
                int n = 2;
                while (true) {
                    int[] newArr = {(fibonacci.get(n-1)[0]+fibonacci.get(n-2)[0]),(fibonacci.get(n-1)[1]+fibonacci.get(n-2)[1])};
                    fibonacci.add(newArr);
                    if (findNum == n) {
                        bw.write(String.valueOf(fibonacci.get(n)[0]) + " " + String.valueOf(fibonacci.get(n)[1]) + "\n");
                        break;
                    }
                    else {
                        n++;
                    }
                }
            }
        }
        bw.close();
    }
}

package bronze1;

import java.io.*;

public class 행렬곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr1 = bf.readLine();
        String[] num1 = numStr1.split(" ");
        int a = Integer.parseInt(num1[0]);
        int b = Integer.parseInt(num1[1]);
        String[][] arr1 = new String[a][b];
        for (int i=0; i<a; i++){
            String str1 = bf.readLine();
            arr1[i] = str1.split(" ");
        }
        String numStr2 = bf.readLine();
        String[] num2 = numStr2.split(" ");
        int c = Integer.parseInt(num2[0]);
        int d = Integer.parseInt(num2[1]);
        String[][] arr2 = new String[c][d];
        for (int i=0; i<c; i++){
            String str2 = bf.readLine();
            arr2[i] = str2.split(" ");
        }

        for (int i=0; i<a; i++){
            for (int j=0; j<d; j++){
                if (j==d-1) {
                    int total = 0;
                    for (int k = 0; k < b; k++) {
                        total += Integer.parseInt(arr1[i][k]) * Integer.parseInt(arr2[k][j]);
                    }
                    bw.write(String.valueOf(total) + '\n');
                }
                else {
                    int total = 0;
                    for (int k = 0; k < b; k++) {
                        total += Integer.parseInt(arr1[i][k]) * Integer.parseInt(arr2[k][j]);
                    }
                    bw.write(String.valueOf(total) + " ");
                }
            }
        }
        bw.close();
    }
}

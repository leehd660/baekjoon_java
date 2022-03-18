package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_9184 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][][] arr = new int[21][21][21];
        for (int i=0; i<21; i++) {
            for (int j=0; j<21; j++) {
                for (int k=0; k<21; k++) {
                    if (i==0 || j==0 || k==0) {
                        arr[i][j][k] = 1;
                    }
                    else if (i<j && j<k) {
                        arr[i][j][k] = arr[i][j][k-1]+arr[i][j-1][k-1]-arr[i][j-1][k];
                    }
                    else {
                        arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                    }
                }
            }
        }
        while (true) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            if (a== -1 && b== -1 && c== -1) {
                break;
            }
            else {
                if (a<=0 || b<=0 || c<=0) {
                    bw.write("w("+a+", "+b+", "+c+") = "+"1"+"\n");
                }
                else if (a>20 || b>20 || c>20) {
                    bw.write("w("+a+", "+b+", "+c+") = "+String.valueOf(arr[20][20][20])+"\n");
                }
                else {
                    bw.write("w(" + a + ", " + b + ", " + c + ") = " + String.valueOf(arr[a][b][c]) + "\n");
                }
            }
        }
        bw.close();
    }
    static int funW(int a, int b, int c) {
        int[][][] arr = new int[a][b][c];
        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                for (int k=0; k<c; k++) {
                    if (i==0 || j==0 || k==0) {
                        arr[i][j][k] = 0;
                    }
                    else if (a>20|| b>20 || c>20) {
                        arr[i][j][k] = arr[20][20][20];
                    }
                }
            }
        }
        return 0;
    }

//    static int funW(int a, int b, int c) {
//        if(a<=0 || b<=0 || c<=0) {
//            return 1;
//        }
//        else if (a>20 || b>20 || c>20) {
//            return funW(20,20,20);
//        }
//        else if (a<b && b<c) {
//            return funW(a,b,c-1)+funW(a,b-1, c-1) - funW(a,b-1,c);
//        }
//        else {
//            return funW(a-1,b,c) + funW(a-1,b-1,c) + funW(a-1,b,c-1) - funW(a-1,b-1,c-1);
//        }
//    }
}

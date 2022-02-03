package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1780 {
    private static int minusNum;
    private static int zeroNum;
    private static int plusNum;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        paper = new int[n][n];
        minusNum = 0;
        zeroNum = 0;
        plusNum = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer paperNum = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(paperNum.nextToken());
            }
        }
        check(n, 0,0);
        bw.write(String.valueOf(minusNum)+"\n");
        bw.write(String.valueOf(zeroNum)+"\n");
        bw.write(String.valueOf(plusNum));
        bw.close();
    }

    static void check(int len, int x, int y) {
        int paperNum = paper[x][y];
        boolean sameCheck = true;
        for (int i=x; i<x+len; i++) {
            for (int j=y; j<y+len; j++) {
                if (paperNum == paper[i][j]) {
                    continue;
                }
                else {
                    sameCheck = false;
                    break;
                }
            }
            if (!sameCheck) break;
        }
        if (sameCheck) {
            switch (paperNum) {
                case -1 : minusNum++; break;
                case 0 : zeroNum++; break;
                case 1 : plusNum++; break;
            }
        }
        else {
            check(len/3, x, y);
            check(len/3, x, y+(len/3));
            check(len/3, x, y+2*(len/3));
            check(len/3, x+(len/3), y);
            check(len/3, x+(len/3), y+(len/3));
            check(len/3, x+(len/3), y+2*(len/3));
            check(len/3, x+2*(len/3), y);
            check(len/3, x+2*(len/3), y+(len/3));
            check(len/3, x+2*(len/3), y+2*(len/3));
        }
    }
}

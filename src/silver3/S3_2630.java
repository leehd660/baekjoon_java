package silver3;

import java.io.*;

public class S3_2630 {
    private static int[][] table;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        table = new int[N][N];
        for (int i=0; i<N; i++) {
            String line = bf.readLine();
            String[] strArr = line.split(" ");
            for (int j=0; j<N; j++) {
                table[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        recursion(N, 0,0);
        bw.write(String.valueOf(white)+"\n");
        bw.write(String.valueOf(blue));
        bw.close();
    }

    static void recursion(int n, int x, int y) {
        int zeroNum=0;
        int oneNum=0;
        boolean check = true;
        for (int i=x; i<x+n; i++) {
            for (int j=y; j<y+n; j++) {
                if (table[i][j] == 0) {
                    zeroNum++;
                }
                else {
                    oneNum++;
                }
                if (zeroNum>0 && oneNum>0) {
                    check = false;
                    break;
                }
            }
            if (!check) break;
        }
        if (check) {
            if (table[x][y] == 0) {
                white++;
            }
            else {
                blue++;
            }
        }
        else {
            recursion(n/2, x, y);
            recursion(n/2, x+(n/2), y);
            recursion(n/2, x, y+(n/2));
            recursion(n/2, x+(n/2), y+(n/2));
        }
    }
}

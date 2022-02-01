package silver1;

import java.io.*;
import java.util.Arrays;

public class S1_2447 {
    private static String[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        table = new String[num][num];
        for (int i=0; i<num; i++) {
            Arrays.fill(table[i], "*");
        }
        divide(num, 0, 0);
        for (int i=0; i<num; i++) {
            for (int j=0; j<num; j++) {
                bw.write(table[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void divide(int len, int x, int y) {
        remove(len/3, x+len/3, y+len/3);
        if (len!=1) {
            divide(len / 3, x, y);
            divide(len / 3, x, y + len / 3);
            divide(len / 3, x, y + 2 * (len / 3));
            divide(len / 3, x + len / 3, y);
            divide(len / 3, x + len / 3, y + 2 * (len / 3));
            divide(len / 3, x + 2 * (len / 3), y);
            divide(len / 3, x + 2 * (len / 3), y + len / 3);
            divide(len / 3, x + 2 * (len / 3), y + 2 * (len / 3));
        }
    }

    static void remove(int len, int x, int y) {
        for (int i=x; i<x+len; i++) {
            for (int j=y; j<y+len; j++) {
                table[i][j] = " ";
            }
        }
    }
}

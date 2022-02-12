package gold5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class G5_10026 {
    private static int n;
    private static String[][] table;
    private static int[][] arr1;
    private static int[][] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        table = new String[n][n];
        for (int i=0; i<n; i++) {
            String line = bf.readLine();
            table[i] = line.split("");
        }
        //정상인 사람 & 적록색약약
        Deque<int[]> deque1 = new ArrayDeque<>();
        Deque<int[]> deque2 = new ArrayDeque<>();
        arr1 = new int[n][n];
        arr2 = new int[n][n];
        int index1 = 1;
        int index2 = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr1[i][j]==0) {
                    int[] pair = {i,j};
                    arr1[i][j] = index1;
                    deque1.add(pair);
                    BFS1(deque1, index1);
                    index1++;
                }
                if (arr2[i][j]==0) {
                    int[] pair = {i,j};
                    arr2[i][j] = index2;
                    deque2.add(pair);
                    BFS2(deque2, index2);
                    index2++;
                }
            }
        }
        bw.write(String.valueOf(index1-1) + " " + String.valueOf(index2-1));
        bw.close();
    }

    static void BFS1 (Deque<int[]> deque, int num) {
        while (!deque.isEmpty()) {
            int x = deque.peekFirst()[0];
            int y = deque.pollFirst()[1];
            if (x-1>=0 && arr1[x-1][y]==0 && table[x-1][y].equals(table[x][y])) {
                arr1[x-1][y] = num;
                int[] pair = {x-1,y};
                deque.add(pair);
            }
            if (y-1>=0 && arr1[x][y-1]==0 && table[x][y-1].equals(table[x][y])) {
                arr1[x][y-1] = num;
                int[] pair = {x,y-1};
                deque.add(pair);
            }
            if (x+1<n && arr1[x+1][y]==0 && table[x+1][y].equals(table[x][y])) {
                arr1[x+1][y] = num;
                int[] pair = {x+1,y};
                deque.add(pair);
            }
            if (y+1<n && arr1[x][y+1]==0 && table[x][y+1].equals(table[x][y])) {
                arr1[x][y+1] = num;
                int[] pair = {x,y+1};
                deque.add(pair);
            }
        }
    }

    static void BFS2 (Deque<int[]> deque, int num) {
        while (!deque.isEmpty()) {
            int x = deque.peekFirst()[0];
            int y = deque.pollFirst()[1];
            if (x-1>=0 && arr2[x-1][y]==0 && colorCheck(table[x-1][y],table[x][y])) {
                arr2[x-1][y] = num;
                int[] pair = {x-1,y};
                deque.add(pair);
            }
            if (y-1>=0 && arr2[x][y-1]==0 && colorCheck(table[x][y-1],table[x][y])) {
                arr2[x][y-1] = num;
                int[] pair = {x,y-1};
                deque.add(pair);
            }
            if (x+1<n && arr2[x+1][y]==0 && colorCheck(table[x+1][y],table[x][y])) {
                arr2[x+1][y] = num;
                int[] pair = {x+1,y};
                deque.add(pair);
            }
            if (y+1<n && arr2[x][y+1]==0 && colorCheck(table[x][y+1],table[x][y])) {
                arr2[x][y+1] = num;
                int[] pair = {x,y+1};
                deque.add(pair);
            }
        }
    }

    static boolean colorCheck (String col1, String col2) {
        boolean answer = true;
        if (col1.equals("R") && col2.equals("B")) {
            answer = false;
        }
        else if (col1.equals("G") && col2.equals("B")) {
            answer = false;
        }
        else if (col1.equals("B") && col2.equals("R")) {
            answer = false;
        }
        else if (col1.equals("B") && col2.equals("G")) {
            answer = false;
        }
        return answer;
    }
}

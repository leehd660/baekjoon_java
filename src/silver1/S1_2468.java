package silver1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class S1_2468 {
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        int maxNum=100;
        int minNum=1;
        for (int i=0; i<n; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                minNum = Math.min(map[i][j], minNum);
                maxNum = Math.max(map[i][j], maxNum);
            }
        }
        visited = new boolean[n][n];
        int answer =1;
        for (int i=minNum+1; i<maxNum; i++) {
            int count = 0;
            Deque<int[]> deque = new ArrayDeque<>();
            for (int x=0; x<n; x++) {
                for (int y=0; y<n; y++) {
                    if (map[x][y]>=i && !visited[x][y]) {
                        int[] arr = {x,y};
                        deque.add(arr);
                        BFS(deque, i);
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
            for (int f=0; f<n; f++) {
                Arrays.fill(visited[f],false);
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
    static void BFS(Deque<int[]> deque, int minNum) {
        int[] xArr = {1,-1,0,0};
        int[] yArr = {0,0,1,-1};
        while (!deque.isEmpty()) {
            int x = deque.peekFirst()[0];
            int y = deque.pollFirst()[1];
            for (int i=0; i<4; i++) {
                if (x+xArr[i]<n && x+xArr[i]>=0 && y+yArr[i]<n && y+yArr[i]>=0 && !visited[x+xArr[i]][y+yArr[i]]
                && map[x+xArr[i]][y+yArr[i]] >= minNum) {
                    int[] arr = {x+xArr[i], y+yArr[i]};
                    deque.add(arr);
                    visited[x+xArr[i]][y+yArr[i]] = true;
                }
            }
            BFS(deque, minNum);
        }
    }
}

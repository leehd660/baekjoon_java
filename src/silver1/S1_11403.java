package silver1;

import java.io.*;
import java.util.*;

public class S1_11403 {
    private static int n;
    private static int[][] arr;
    private static int[][] answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        answer = new int[n][n];
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for (int i=0; i<n; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 1) {
                    deque.add(j);
                    visited[j] = true;
                    answer[i][j] = 1;
                }
            }
            BFS(i, deque);
            Arrays.fill(visited,false);
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                bw.write(String.valueOf(answer[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void BFS (int index, Deque<Integer> deque) {
        while (!deque.isEmpty()) {
            int num = deque.pollFirst();
            for (int i=0; i<n; i++) {
                if (arr[num][i]==1 && !visited[i]) {
                    deque.add(i);
                    visited[i] = true;
                    answer[index][i] = 1;
                }
            }
        }
    }
}


//1차 시도 실패
//    private static int N;
//    private static int[][] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        N = Integer.parseInt(bf.readLine());
//        arr = new int[N][N];
//        for (int i=0; i<N; i++) {
//            StringTokenizer token = new StringTokenizer(bf.readLine());
//            for (int j=0; j<N; j++) {
//                arr[i][j] = Integer.parseInt(token.nextToken());
//            }
//        }
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                if (arr[i][j] == 1) {
//                    check(i,j);
//                }
//            }
//        }
//        for (int i=0;i<N;i++) {
//            for (int j=0;j<N;j++) {
//                bw.write(String.valueOf(arr[i][j])+" ");
//            }
//            bw.write("\n");
//        }
//        bw.close();
//    }
//    static void check(int x, int y) {
//        for (int i=0; i<N; i++) {
//            if (arr[y][i] == 1) {
//                if (arr[x][i] == 0) {
//                    arr[x][i] = 1;
//                    check(y,i);
//                }
//            }
//        }
//    }

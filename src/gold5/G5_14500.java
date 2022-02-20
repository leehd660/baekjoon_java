package gold5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G5_14500 {
    private static int N;
    private static int M;
    private static int max;
    private static int[][] paper;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        max = 0;
        List<int[]> list = new ArrayList<>();
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int[] arr = {i, j};
                list.add(arr);
                visited[i][j] = true;
                DFS(list);
                list.remove(list.size() - 1);
                visited[i][j] = false;
                DFS5(i, j);
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
    }

    static void DFS(List<int[]> list) {
        if (list.size() == 4) {
            int sum = 0;
            for (int[] arr : list) {
                sum += paper[arr[0]][arr[1]];
            }
            max = Math.max(max, sum);
        } else {
            int x = list.get(list.size() - 1)[0];
            int y = list.get(list.size() - 1)[1];
            int[] xArr = {0, 0, -1, 1};
            int[] yArr = {-1, 1, 0, 0};
            for (int i = 0; i < 4; i++) {
                if (x + xArr[i] >= 0 && x + xArr[i] < N && y + yArr[i] >= 0 && y + yArr[i] < M && !visited[x + xArr[i]][y + yArr[i]]) {
                    int[] arr = {x + xArr[i], y + yArr[i]};
                    list.add(arr);
                    visited[x + xArr[i]][y + yArr[i]] = true;
                    DFS(list);
                    list.remove(list.size() - 1);
                    visited[x + xArr[i]][y + yArr[i]] = false;
                }
            }
        }
    }


    static void DFS5(int x, int y) {
        int[] xArr = {0, 0, -1, 1};
        int[] yArr = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            sum += paper[x][y];
            boolean check = true;
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    if (x + xArr[j] >= 0 && x + xArr[j] < N && y + yArr[j] >= 0 && y + yArr[j] < M) {
                        sum += paper[x + xArr[j]][y + yArr[j]];
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                max = Math.max(max, sum);
            } else {
                continue;
            }
        }
    }
}


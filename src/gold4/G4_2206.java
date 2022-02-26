package gold4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class G4_2206 {
    private static int N;
    private static int M;
    private static int count;
    private static int answer;
    private static int[] xArr;
    private static int[] yArr;
    private static int[][] map;
    private static boolean[][] visited;
    private static Deque<Integer> dequeX;
    private static Deque<Integer> dequeY;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            String str = bf.readLine();
            String[] strArr = str.split("");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        xArr = new int[]{0,0,1,-1};
        yArr = new int[]{1,-1,0,0};
        dequeX = new ArrayDeque<>();
        dequeY = new ArrayDeque<>();
        answer = N*M;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    checkRoad();
                    map[i][j] = 1;
                    for (int k=0; k<N; k++) {
                        Arrays.fill(visited[k],false);
                    }
                }
            }
        }
        if (answer == N*M) {
            bw.write("-1");
        }
        else {
            bw.write(String.valueOf(answer));
        }
        bw.close();
    }

    static void checkRoad() {
        dequeX.add(0);
        dequeY.add(0);
        count = 1;
        visited[0][0] = true;
        while (!dequeX.isEmpty() && !visited[N-1][M-1]) {
            int size = dequeX.size();
            for (int s=0; s<size; s++) {
                int x = dequeX.pollFirst();
                int y = dequeY.pollFirst();
                for (int i = 0; i < 4; i++) {
                    if (x + xArr[i] >= 0 && x + xArr[i] < N && y + yArr[i] >= 0 && y + yArr[i] < M && map[x + xArr[i]][y + yArr[i]] == 0 && !visited[x + xArr[i]][y + yArr[i]]) {
                        visited[x + xArr[i]][y + yArr[i]] = true;
                        dequeX.add(x+xArr[i]);
                        dequeY.add(y+yArr[i]);
                    }
                }
            }
            count++;
//            if (visited[N-1][M-1]) break;
        }
        dequeX.clear();
        dequeY.clear();
        if (visited[N-1][M-1]) {
            answer = Math.min(count, answer);
        }
        count = 1;
    }
}

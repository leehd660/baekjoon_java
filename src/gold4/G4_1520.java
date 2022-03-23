package gold4;

import java.io.*;
import java.util.StringTokenizer;

public class G4_1520 {
    private static int N;
    private static int M;
    private static int answer;
    private static int[][] map;
//    private static boolean[][] visited;
//    private static Deque<Integer> dequeX;
//    private static Deque<Integer> dequeY;
    private static int[] xArr;
    private static int[] yArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        xArr = new int[]{0,0,1,-1};
        yArr = new int[]{1,-1,0,0};
        answer = 0;
//        visited = new boolean[N][M];
//        dequeX = new ArrayDeque<>();
//        dequeY = new ArrayDeque<>();
//        dequeX.add(0);
//        dequeY.add(0);
//        visited[0][0] = true;
        DFS(0,0);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void DFS(int x, int y) {
        if (x == N-1 && y==M-1) {
            answer ++;
        }
        else {
//            int x = dequeX.peekLast();
//            int y = dequeY.peekLast();
            for (int i=0; i<4; i++) {
                if (x+xArr[i]>=0 && x+xArr[i]<N && y+yArr[i]>=0 && y+yArr[i]<M
                        &&  map[x][y]>map[x+xArr[i]][y+yArr[i]]) {
//                    visited[dequeX.peekLast()+xArr[i]][dequeY.peekLast()+yArr[i]] = true;
//                    dequeX.add(dequeX.peekLast()+xArr[i]);
//                    dequeY.add(dequeY.peekLast()+yArr[i]);
                    DFS(x+xArr[i],y+yArr[i]);
//                    visited[dequeX.peekLast()][dequeY.peekLast()] = false;
//                    dequeX.pollLast();
//                    dequeY.pollLast();
                }
            }
        }
    }
}

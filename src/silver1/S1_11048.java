package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] maze = new int[N][M];
        int[][] dp = new int[N][M];
        for (int i=0; i<N; i++) {
            StringTokenizer wall = new StringTokenizer(bf.readLine());
            for (int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(wall.nextToken());
            }
        }
        dp[0][0] = maze[0][0];
        for (int i=1; i<N; i++) {
            dp[i][0] = dp[i-1][0] + maze[i][0];
        }
        for (int i=1; i<M; i++) {
            dp[0][i] = dp[0][i-1] + maze[0][i];
        }
        for (int i=1; i<N; i++) {
            for (int j=1; j<M; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+maze[i][j];
            }
        }
        bw.write(String.valueOf(dp[N-1][M-1]));
        bw.close();
    }


//    DFS방법으로 문제를 해결하려했더니 시간 초과
//
//    private static int N;
//    private static int M;
//    private static int answer;
//    private static List<Integer> listX;
//    private static List<Integer> listY;
//    private static int[][] maze;
//    private static int[] xArr;
//    private static int[] yArr;
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer token = new StringTokenizer(bf.readLine());
//        N = Integer.parseInt(token.nextToken());
//        M = Integer.parseInt(token.nextToken());
//        maze = new int[N][M];
//        for (int i=0; i<N; i++) {
//            StringTokenizer wall = new StringTokenizer(bf.readLine());
//            for (int j=0; j<M; j++) {
//                maze[i][j] = Integer.parseInt(wall.nextToken());
//            }
//        }
//        xArr = new int[]{1,0,1};
//        yArr = new int[]{0,1,1};
//        listX = new ArrayList<>();
//        listY = new ArrayList<>();
//        listX.add(0);
//        listY.add(0);
//        answer =0;
//        findCandy(maze[0][0]);
//        bw.write(String.valueOf(answer));
//        bw.close();
//    }
//    static void findCandy(int sum) {
//        int x = listX.get(listX.size()-1);
//        int y = listY.get(listY.size()-1);
//        if (x==N-1 && y==M-1) {
//            answer = Math.max(answer, sum);
//        }
//        else {
//            for (int i=0; i<3; i++) {
//                if (x+xArr[i]<N && y+yArr[i]<M) {
//                    listX.add(x+xArr[i]);
//                    listY.add(y+yArr[i]);
//                    findCandy(sum + maze[x+xArr[i]][y+yArr[i]]);
//                    listX.remove(listX.size()-1);
//                    listY.remove(listY.size()-1);
//                }
//            }
//        }
//    }
}

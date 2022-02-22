package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1890 {
    private static int N;
    private static int[][] map;
    private static long[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];
        DP = new long[N][N];
        DP[0][0] = 1;
        for (int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int x=i-1; x>=0; x--) {
                    if (x+map[x][j] == i && DP[x][j]!=0) {

                        DP[i][j]+=DP[x][j];

                    }
                }
                for (int y=j-1; y>=0; y--) {
                    if (y+map[i][y] == j && DP[i][y]!=0) {
                        DP[i][j]+=DP[i][y];
                    }
                }
            }
        }
        bw.write(String.valueOf(DP[N-1][N-1]));
        bw.close();
    }
}

    //DFS로 문제 해결했더니 메모리 초과 발생

//    private static int N;
//    private static long count;
//    private static int[][] map;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        N = Integer.parseInt(bf.readLine());
//        count = 0;
//        map = new int[N][N];
//        for (int i=0; i<N; i++) {
//            StringTokenizer token = new StringTokenizer(bf.readLine());
//            for (int j=0; j<N; j++) {
//                map[i][j] = Integer.parseInt(token.nextToken());
//            }
//        }
//        List<int[]> list = new ArrayList<>();
//        int[] startArr = {0,0};
//        list.add(startArr);
//        DFS(list);
//        bw.write(String.valueOf(count));
//        bw.close();
//    }
//
//    static void DFS (List<int[]> list) {
//        int[] arr = list.get(list.size()-1);
//        if (arr[0] == N-1 && arr[1] == N-1) {
//            count++;
//        }
//        else {
//            int jump = map[arr[0]][arr[1]];
//            if (jump != 0) {
//                //아래로 먼저 점프
//                if (arr[0]+jump<N) {
//                    int[] nextArr = {arr[0]+jump, arr[1]};
//                    list.add(nextArr);
//                    DFS(list);
//                    list.remove(list.size()-1);
//                }
//                //오른쪽으로 점프
//                if (arr[1]+jump<N) {
//                    int[] nextArr = {arr[0], arr[1]+jump};
//                    list.add(nextArr);
//                    DFS(list);
//                    list.remove(list.size()-1);
//                }
//            }
//
//        }
//    }


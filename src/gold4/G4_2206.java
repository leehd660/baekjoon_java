package gold4;

import java.io.*;
import java.util.*;

public class G4_2206 {
    private static int N;
    private static int M;
    private static int crashCount;
    private static int answer;
    private static int[] xArr;
    private static int[] yArr;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> listX;
    private static List<Integer> listY;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            String str = bf.readLine();
            String[] strArr = str.split("");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        crashCount = 0;
        answer = N*M;
        xArr = new int[]{0,0,1,-1};
        yArr = new int[]{1,-1,0,0};
        visited = new boolean[N][M];
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        listX.add(0);
        listY.add(0);
        visited[0][0] = true;
        DFS();
        if (answer == N*M) {
            bw.write("-1");
        }
        else {
            bw.write(String.valueOf(answer));
        }
        bw.close();
    }

    static void DFS () {
        if (visited[N-1][M-1]) {
            answer = Math.min(answer, listX.size());
        }
        else {
            int x = listX.get(listX.size() - 1);
            int y = listY.get(listY.size() - 1);
            for (int i = 0; i < 4; i++) {
                if (x + xArr[i] >= 0 && x + xArr[i] < N && y + yArr[i] >= 0 && y + yArr[i] < M && !visited[x + xArr[i]][y + yArr[i]]) {
                    if (crashCount == 0 && map[x + xArr[i]][y + yArr[i]] == 1) {
                        //벽을 만나면, DFS->BFS 변경 가능하게 만들어야하나?
                        crashCount = 1;
                        listX.add(x + xArr[i]);
                        listY.add(y + yArr[i]);
                        visited[x + xArr[i]][y + yArr[i]] = true;
                        DFS();
                        crashCount = 0;
                        listX.remove(listX.size()-1);
                        listY.remove(listX.size()-1);
                        visited[x + xArr[i]][y + yArr[i]] = false;
                    } else if (map[x + xArr[i]][y + yArr[i]] == 0) {
                        listX.add(x + xArr[i]);
                        listY.add(y + yArr[i]);
                        visited[x + xArr[i]][y + yArr[i]] = true;
                        DFS();
                        listX.remove(listX.size()-1);
                        listY.remove(listX.size()-1);
                        visited[x + xArr[i]][y + yArr[i]] = false;
                    }
                }
            }
        }
    }
}


//    모든 벽을 탐색해서 벽을 하나씩 제거한 후 BFS방식을 취한 방법. -> 이 방법 시, 시간 초과 발생

//public class G4_2206 {
//    private static int N;
//    private static int M;
//    private static int count;
//    private static int answer;
//    private static int[] xArr;
//    private static int[] yArr;
//    private static int[][] map;
//    private static boolean[][] visited;
//    private static Deque<Integer> dequeX;
//    private static Deque<Integer> dequeY;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
//        N = Integer.parseInt(NMtoken.nextToken());
//        M = Integer.parseInt(NMtoken.nextToken());
//        map = new int[N][M];
//        visited = new boolean[N][M];
//        for (int i=0; i<N; i++) {
//            String str = bf.readLine();
//            String[] strArr = str.split("");
//            for (int j=0; j<M; j++) {
//                map[i][j] = Integer.parseInt(strArr[j]);
//            }
//        }
//        xArr = new int[]{0,0,1,-1};
//        yArr = new int[]{1,-1,0,0};
//        dequeX = new ArrayDeque<>();
//        dequeY = new ArrayDeque<>();
//        answer = N*M;
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<M; j++) {
//                if (map[i][j] == 1) {
//                    map[i][j] = 0;
//                    checkRoad();
//                    map[i][j] = 1;
//                    for (int k=0; k<N; k++) {
//                        Arrays.fill(visited[k],false);
//                    }
//                }
//            }
//        }
//        if (answer == N*M) {
//            bw.write("-1");
//        }
//        else {
//            bw.write(String.valueOf(answer));
//        }
//        bw.close();
//    }
//
//    static void checkRoad() {
//        dequeX.add(0);
//        dequeY.add(0);
//        count = 1;
//        visited[0][0] = true;
//        while (!dequeX.isEmpty() && !visited[N-1][M-1]) {
//            int size = dequeX.size();
//            for (int s=0; s<size; s++) {
//                int x = dequeX.pollFirst();
//                int y = dequeY.pollFirst();
//                for (int i = 0; i < 4; i++) {
//                    if (x + xArr[i] >= 0 && x + xArr[i] < N && y + yArr[i] >= 0 && y + yArr[i] < M && map[x + xArr[i]][y + yArr[i]] == 0 && !visited[x + xArr[i]][y + yArr[i]]) {
//                        visited[x + xArr[i]][y + yArr[i]] = true;
//                        dequeX.add(x+xArr[i]);
//                        dequeY.add(y+yArr[i]);
//                    }
//                }
//            }
//            count++;
//        }
//        dequeX.clear();
//        dequeY.clear();
//        if (visited[N-1][M-1]) {
//            answer = Math.min(count, answer);
//        }
//        count = 1;
//    }
//}

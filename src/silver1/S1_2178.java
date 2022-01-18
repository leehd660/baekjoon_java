package silver1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S1_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        StringTokenizer NMtoken = new StringTokenizer(NMstr);
        int N = Integer.parseInt(NMtoken.nextToken());
        int M = Integer.parseInt(NMtoken.nextToken());
        int[][] maze = new int[N][M];
        int[][] visited = new int[N][M];
        for (int i=0; i<N; i++) {
            String mazeMap = bf.readLine();
            String[] mapArr = mazeMap.split("");
            for (int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(mapArr[j]);
                visited[i][j] = Integer.parseInt(mapArr[j]);
            }
        }
        //count - 몇개의 칸을 밟아야 갈 수 있는 위치인지 파악
        //numbers - 턴마다 갈 수 있는 위치의 수
        int count = 1;
        int numbers = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        int[] location = {0,0};
        deque.add(location);
        while (true) {
            for (int i=0; i<numbers; i++) {
                int[] visitedLocation = deque.pollFirst();
                int x = visitedLocation[0];
                int y = visitedLocation[1];
                if (x > 0) { // 위에 칸이 있는지 확인
                    int[] next = {x - 1, y};
                    if (maze[x - 1][y] == 1 && visited[x - 1][y] == 1) {
                        deque.add(next);
                        visited[x - 1][y] = 0;
                    }
                }
                if (y > 0) { // 왼쪽으로 갈 수 있는 칸이 있는지 확인
                    int[] next = {x, y - 1};
                    if (maze[x][y - 1] == 1 && visited[x][y - 1] == 1) {
                        deque.add(next);
                        visited[x][y - 1] = 0;
                    }
                }
                if (x < N - 1) { // 아래쪽으로 갈 수 있는 칸이 있는지 확인
                    int[] next = {x + 1, y};
                    if (maze[x + 1][y] == 1 && visited[x + 1][y] == 1) {
                        deque.add(next);
                        visited[x + 1][y] = 0;
                    }
                }
                if (y < M - 1) { // 오른쪽으로 갈 수 있는 칸이 있는지 확인
                    int[] next = {x, y + 1};
                    if (maze[x][y + 1] == 1 && visited[x][y + 1] == 1) {
                        deque.add(next);
                        visited[x][y + 1] = 0;
                    }
                }
            }
            numbers = deque.size();
            count++;
            if (visited[N-1][M-1] == 0) {
                break;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}

//        BFS방식으로 문제 풀어봤는데 시간초과 발생
//    private static int N;
//    private static int M;
//    private static int[][] maze;
//    private static int[][] visited;
//    private static int minAnswer;
//
//    public static void main (String[]args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String NMstr = bf.readLine();
//        StringTokenizer NMtoken = new StringTokenizer(NMstr);
//        N = Integer.parseInt(NMtoken.nextToken());
//        M = Integer.parseInt(NMtoken.nextToken());
//        maze = new int[N][M];
//        visited = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            String mazeRoad = bf.readLine();
//            String[] mazeArr = mazeRoad.split("");
//            //tokenizer는 한글자씩 불리 불가능
//            //            StringTokenizer roadToken = new StringTokenizer(mazeRoad,"");
//            for (int j = 0; j < M; j++) {
//                maze[i][j] = Integer.parseInt(mazeArr[j]);
//                visited[i][j] = Integer.parseInt(mazeArr[j]);
//            }
//        }
//        // list를 이용해서 BFS구현(갈 수 있는 모든 방법의 수를 BFS로 계산하여, 그 중 최솟값을 찾음.)
//        // visited 함수를 이용하여 왔던 길은 다시 못돌아가게 함.
//        // list안에 int배열을 이용해서 0번째는 미로의 x값, 1번재는 미로의 y값을 대입하여 미로의 위치 확인.
//        minAnswer = N * M;
//        List<int[]> list = new ArrayList<>();
//        int[] location = {0, 0};
//        list.add(location);
//        visited[location[0]][location[1]] = 0;
//        DFS(list);
//        bw.write(String.valueOf(minAnswer));
//        bw.close();
//    }
//
//    static void DFS (List < int[]>list){
//        int[] recentLocation = list.get(list.size() - 1);
//        int i = recentLocation[0];
//        int j = recentLocation[1];
//        if (i == N - 1 && j == M - 1) {
//            minAnswer = Math.min(minAnswer, list.size());
//        } else {
//            if (i > 0) { // 위에 칸이 있는지 확인
//                int[] location = {i - 1, j};
//                if (maze[i - 1][j] == 1 && visited[i - 1][j] == 1) {
//                    list.add(location);
//                    visited[i - 1][j] = 0;
//                    DFS(list);
//                    list.remove(list.size() - 1);
//                    visited[i - 1][j] = 1;
//                }
//            }
//            if (j > 0) { // 왼쪽으로 갈 수 있는 칸이 있는지 확인
//                int[] location = {i, j - 1};
//                if (maze[i][j - 1] == 1 && visited[i][j - 1] == 1) {
//                    list.add(location);
//                    visited[i][j - 1] = 0;
//                    DFS(list);
//                    list.remove(list.size() - 1);
//                    visited[i][j - 1] = 1;
//                }
//            }
//            if (i < N - 1) { // 아래쪽으로 갈 수 있는 칸이 있는지 확인
//                int[] location = {i + 1, j};
//                if (maze[i + 1][j] == 1 && visited[i + 1][j] == 1) {
//                    list.add(location);
//                    visited[i + 1][j] = 0;
//                    DFS(list);
//                    list.remove(list.size() - 1);
//                    visited[i + 1][j] = 1;
//                }
//            }
//            if (j < M - 1) { // 오른쪽으로 갈 수 있는 칸이 있는지 확인
//                int[] location = {i, j + 1};
//                if (maze[i][j + 1] == 1 && visited[i][j + 1] == 1) {
//                    list.add(location);
//                    visited[i][j + 1] = 0;
//                    DFS(list);
//                    list.remove(list.size() - 1);
//                    visited[i][j + 1] = 1;
//                }
//            }
//        }
//    }
//}
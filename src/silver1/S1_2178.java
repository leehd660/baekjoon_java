package silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_2178 {
//        BFS방식으로 문제 풀어봤는데 시간초과 발생
    private static int N;
    private static int M;
    private static int[][] maze;
    private static int[][] visited;
    private static int minAnswer;

    public static void main (String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        StringTokenizer NMtoken = new StringTokenizer(NMstr);
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        maze = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String mazeRoad = bf.readLine();
            String[] mazeArr = mazeRoad.split("");
            //tokenizer는 한글자씩 불리 불가능
            //            StringTokenizer roadToken = new StringTokenizer(mazeRoad,"");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(mazeArr[j]);
                visited[i][j] = Integer.parseInt(mazeArr[j]);
            }
        }
        // list를 이용해서 BFS구현(갈 수 있는 모든 방법의 수를 BFS로 계산하여, 그 중 최솟값을 찾음.)
        // visited 함수를 이용하여 왔던 길은 다시 못돌아가게 함.
        // list안에 int배열을 이용해서 0번째는 미로의 x값, 1번재는 미로의 y값을 대입하여 미로의 위치 확인.
        minAnswer = N * M;
        List<int[]> list = new ArrayList<>();
        int[] location = {0, 0};
        list.add(location);
        visited[location[0]][location[1]] = 0;
        DFS(list);
        bw.write(String.valueOf(minAnswer));
        bw.close();
    }

    static void DFS (List < int[]>list){
        int[] recentLocation = list.get(list.size() - 1);
        int i = recentLocation[0];
        int j = recentLocation[1];
        if (i == N - 1 && j == M - 1) {
            minAnswer = Math.min(minAnswer, list.size());
        } else {
            if (i > 0) { // 위에 칸이 있는지 확인
                int[] location = {i - 1, j};
                if (maze[i - 1][j] == 1 && visited[i - 1][j] == 1) {
                    list.add(location);
                    visited[i - 1][j] = 0;
                    DFS(list);
                    list.remove(list.size() - 1);
                    visited[i - 1][j] = 1;
                }
            }
            if (j > 0) { // 왼쪽으로 갈 수 있는 칸이 있는지 확인
                int[] location = {i, j - 1};
                if (maze[i][j - 1] == 1 && visited[i][j - 1] == 1) {
                    list.add(location);
                    visited[i][j - 1] = 0;
                    DFS(list);
                    list.remove(list.size() - 1);
                    visited[i][j - 1] = 1;
                }
            }
            if (i < N - 1) { // 아래쪽으로 갈 수 있는 칸이 있는지 확인
                int[] location = {i + 1, j};
                if (maze[i + 1][j] == 1 && visited[i + 1][j] == 1) {
                    list.add(location);
                    visited[i + 1][j] = 0;
                    DFS(list);
                    list.remove(list.size() - 1);
                    visited[i + 1][j] = 1;
                }
            }
            if (j < M - 1) { // 오른쪽으로 갈 수 있는 칸이 있는지 확인
                int[] location = {i, j + 1};
                if (maze[i][j + 1] == 1 && visited[i][j + 1] == 1) {
                    list.add(location);
                    visited[i][j + 1] = 0;
                    DFS(list);
                    list.remove(list.size() - 1);
                    visited[i][j + 1] = 1;
                }
            }
        }
    }
}
package gold5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class G5_7576 {
    private static int N;
    private static int M;
    private static int[][] box;
    private static int count;
    private static Deque<int[]> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        StringTokenizer NMtoken = new StringTokenizer(NMstr);
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        box = new int[M][N];
        deque = new ArrayDeque<>();
        for (int i=0; i<M; i++) {
            String tomatoStr = bf.readLine();
            StringTokenizer tomatoToken = new StringTokenizer(tomatoStr);
            for (int j=0; j<N; j++) {
                int state = Integer.parseInt(tomatoToken.nextToken());
                box[i][j] = state;
                if (state == 1) {
                    int[] location = {i,j};
                    deque.add(location);
                    //2는 이미 센 토마토라는 걸 의미
                    box[i][j] = 2;
                }
            }
        }
        count = -1;
        int[] checkNum = check();
        if (checkNum[0] + deque.size() == N*M) {
            bw.write(String.valueOf(0));
        }
        else{
            while (!deque.isEmpty()) {
                int dequeSize = deque.size();
                for (int i = 0; i < dequeSize; i++) {
                    int[] arr = deque.pollFirst();
                    int x = arr[0];
                    int y = arr[1];
                    if (x > 0) { // 위에 칸이 있는지 확인
                        if (box[x - 1][y] == 0) {
                            box[x - 1][y] = 2;
                            int[] newArr = {x - 1, y};
                            deque.add(newArr);
                        }
                    }
                    if (y > 0) { // 왼쪽으로 갈 수 있는 칸이 있는지 확인
                        if (box[x][y - 1] == 0) {
                            box[x][y - 1] = 2;
                            int[] newArr = {x, y - 1};
                            deque.add(newArr);
                        }
                    }
                    if (x < M - 1) { // 아래쪽으로 갈 수 있는 칸이 있는지 확인
                        if (box[x + 1][y] == 0) {
                            box[x + 1][y] = 2;
                            int[] newArr = {x + 1, y};
                            deque.add(newArr);
                        }
                    }
                    if (y < N - 1) { // 오른쪽으로 갈 수 있는 칸이 있는지 확인
                        if (box[x][y + 1] == 0) {
                            box[x][y + 1] = 2;
                            int[] newArr = {x, y + 1};
                            deque.add(newArr);
                        }
                    }
                }
                count++;
            }
            int[] checkNum2 = check();
            if (checkNum2[1] > 0) {
                bw.write(String.valueOf(-1));
            } else {
                bw.write(String.valueOf(count));
            }
        }
        bw.close();
    }

    static int[] check() {
        int[] count = new int[3];
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (box[i][j] == -1) {
                    count[0]++;
                }
                else if (box[i][j] == 0) {
                    count[1]++;
                }
                else {
                    count[2]++;
                }
            }
        }
        return count;
    }
}

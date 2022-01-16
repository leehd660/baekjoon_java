package silver2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S2_1012 {
    private static int[][] table;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        for (int caseNum=0; caseNum<testNum; caseNum++) {
            String info = bf.readLine();
            String[] infoArr = info.split(" ");
            M = Integer.parseInt(infoArr[0]);
            N = Integer.parseInt(infoArr[1]);
            int K = Integer.parseInt(infoArr[2]);
            table = new int[N][M];
            for (int i=0; i<K; i++) {
                String locationStr = bf.readLine();
                String[] locationArr = locationStr.split(" ");
                int x = Integer.parseInt(locationArr[1]);
                int y = Integer.parseInt(locationArr[0]);
                table[x][y] = 1;
            }
            Deque<Vegetable> deque = new ArrayDeque<>();
            int count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (table[i][j] ==1) {
                        Vegetable vegetable = new Vegetable(i,j);
                        table[i][j] = 0;
                        deque.add(vegetable);
                        DFS(deque);
                        count ++;
                    }
                    else {
                        continue;
                    }
                }
            }
            bw.write(String.valueOf(count)+"\n");
        }
        bw.close();
    }

    static void DFS (Deque<Vegetable> deque) {
        while (!deque.isEmpty()) {
            Vegetable vegetable = deque.pollFirst();
            int i = vegetable.x;
            int j = vegetable.y;
            if (i > 0) { //위쪽 밭을 확인
                if (table[i - 1][j] == 1) {
                    Vegetable vege = new Vegetable(i - 1, j);
                    table[i - 1][j] = 0;
                    deque.add(vege);
                }
            }
            if (j > 0) { // 왼쪽 밭을 확인
                if (table[i][j - 1] == 1) {
                    Vegetable vege = new Vegetable(i, j - 1);
                    table[i][j - 1] = 0;
                    deque.add(vege);
                }
            }
            if (j < M - 1) { // 오른쪽 밭을 확인
                if (table[i][j + 1] == 1) {
                    Vegetable vege = new Vegetable(i, j + 1);
                    table[i][j + 1] = 0;
                    deque.add(vege);
                }
            }
            if (i < N - 1) { // 아래쪽 밭을 확인
                if (table[i + 1][j] == 1) {
                    Vegetable vege = new Vegetable(i + 1, j);
                    table[i + 1][j] = 0;
                    deque.add(vege);
                }
            }
        }
    }

    static class Vegetable {
        int x;
        int y;

        Vegetable(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//{
//    DF로 풀었는데 n모양의 밭은 해결할 수 없었음.
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int testCase = Integer.parseInt(bf.readLine());
//        for (int caseNum=0; caseNum<testCase; caseNum++) {
//            String info = bf.readLine();
//            String[] infoArr = info.split(" ");
//            int M = Integer.parseInt(infoArr[0]);
//            int N = Integer.parseInt(infoArr[1]);
//            int K = Integer.parseInt(infoArr[2]);
//            int[][] table = new int[N][M];
//            for (int i=0; i<K; i++) {
//                String locationStr = bf.readLine();
//                String[] locationArr = locationStr.split(" ");
//                int x = Integer.parseInt(locationArr[1]);
//                int y = Integer.parseInt(locationArr[0]);
//                table[x][y] = 1;
//            }
//
//            for (int i=0; i<N; i++) {
//                for (int j=0; j<M; j++) {
//                    if (table[i][j] ==1) {
//                        if (i>0 && j>0) {
//                            table[i][j] += table[i-1][j] + table[i][j-1];
//                            table[i-1][j] = 0;
//                            table[i][j-1] = 0;
//                        }
//                        else if (i>0) {
//                            table[i][j] += table[i-1][j];
//                            table[i-1][j] = 0;
//                        }
//                        else if (j>0) {
//                            table[i][j] += table[i][j-1];
//                            table[i][j-1] = 0;
//                        }
//                    }
//                    else {
//                        continue;
//                    }
//                }
//            }
//            int count = 0;
//            for (int i=0; i<N; i++) {
//                for (int j=0; j<M; j++) {
//                    if (table[i][j] != 0) {
//                        count ++;
//                    }
//                }
//                bw.write("\n");
//            }
//            bw.write(String.valueOf(count)+"\n");
//        }
//        bw.close();
//    }
//}

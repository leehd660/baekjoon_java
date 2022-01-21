package gold5;

import java.io.*;

public class G5_9663 {
    private static int[][] chess;
    private static int N;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        N = Integer.parseInt(numStr);
        chess = new int[N][N];
        //DFS방식으로 모든 방법을 읽음.
//        List<int[]> list = new ArrayList<>();
        count = 0;
//        int[][] visited = new int[N][N];
        int num = 1;
        for (int j=0; j<N; j++) {
            int[] arr = {0,j};
//            list.add(arr);
            chess[0][j] = num;
            checkChess(num,0,j);
            DFS(num, 0, chess);
//            list.remove(list.size()-1);
//            num--;
            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    if (chess[x][y]==1) {
                        chess[x][y] = 0;
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

    static void DFS(int num, int x, int[][] chess) {
        if (num == N) {
            count++;
        }
        else {
            if (x+1<=N-1) {
                for (int j = 0; j < N; j++) {
                    if (chess[x + 1][j] == 0) {
//                    int[] arr = {x+1,j};
//                    list.add(arr);
                        num++;
//                    chess[x+1][j] = list.size();
                        chess[x + 1][j] = num;
                        checkChess(num, x + 1, j);
                        DFS(num, x + 1, chess);
                        for (int x1 = num-1; x1 < N; x1++) {
                            for (int y = 0; y < N; y++) {
                                if (chess[x1][y] == num) {
                                    chess[x1][y] = 0;
                                }
                            }
                        }
//                    list.remove(list.size()-1);
                        num--;
                    }
                }
            }
        }
    }

    static void checkChess(int num, int x, int y) {
        for (int i=0; i<N; i++) {
            if (chess[x][i] == 0) {
                chess[x][i] = num;
            }
            if (chess[i][y] == 0) {
                chess[i][y] = num;
            }
            try {
                if (chess[x-i][y-i] == 0) {
                    chess[x - i][y - i] = num;
                }
            }catch(IndexOutOfBoundsException E) { }
            try {
                if (chess[x+i][y+i] == 0) {
                    chess[x + i][y + i] = num;
                }
            }catch(IndexOutOfBoundsException E) { }
            try {
                if (chess[x-i][y+i] == 0) {
                    chess[x - i][y + i] = num;
                }
            }catch(IndexOutOfBoundsException E) { }
            try {
                if (chess[x+i][y-i] == 0) {
                    chess[x + i][y - i] = num;
                }
            }catch(IndexOutOfBoundsException E) { }
        }
    }
}
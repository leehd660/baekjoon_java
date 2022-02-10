package gold5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class G5_7569 {
    private static int[][][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer MNHtoken = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(MNHtoken.nextToken());
        int N = Integer.parseInt(MNHtoken.nextToken());
        int H = Integer.parseInt(MNHtoken.nextToken());
        int babyTomato = 0;
        int adultTomato = 0;
        int notTomato = 0;
        box = new int[H][M][N];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                StringTokenizer tomatoToken = new StringTokenizer(bf.readLine());
                for (int k=0; k<M; k++) {
                    int stateTomato = Integer.parseInt(tomatoToken.nextToken());
                    box[i][k][j] = stateTomato;
                    if (stateTomato==0) {
                        babyTomato++;
                    }
                    else if (stateTomato==-1) {
                        notTomato++;
                    }
                    else {
                        adultTomato++;
                        int[] arr = {i,k,j};
                        deque.add(arr);
                    }
                }
            }
        }
        if (adultTomato+notTomato==M*N*H) {
            bw.write(String.valueOf(0));
        }
        else {
            int day = 2;
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i=0; i<size; i++) {
                    int h = deque.peekFirst()[0];
                    int m = deque.peekFirst()[1];
                    int n = deque.pollFirst()[2];
                    if (h-1>=0) {
                        if (box[h-1][m][n] == 0) {
                            box[h-1][m][n] = day;
                            int[] arr = {h-1,m,n};
                            deque.add(arr);
                            babyTomato--;adultTomato++;
                        }
                    }
                    if (h+1<H) {
                        if (box[h+1][m][n] == 0) {
                            box[h+1][m][n] = day;
                            int[] arr = {h+1,m,n};
                            deque.add(arr);
                            babyTomato--;adultTomato++;
                        }
                    }
                    if (m-1>=0) {
                        if (box[h][m-1][n] == 0) {
                            box[h][m-1][n] = day;
                            int[] arr = {h,m-1,n};
                            deque.add(arr);
                            babyTomato--;adultTomato++;
                        }
                    }
                    if (m+1<M) {
                        if (box[h][m+1][n] == 0) {
                            box[h][m+1][n] = day;
                            int[] arr = {h,m+1,n};
                            deque.add(arr);
                            babyTomato--;adultTomato++;
                        }
                    }
                    if (n-1>=0) {
                        if (box[h][m][n-1] == 0) {
                            box[h][m][n-1] = day;
                            int[] arr = {h,m,n-1};
                            deque.add(arr);
                            babyTomato--;adultTomato++;
                        }
                    }
                    if (n+1<N) {
                        if (box[h][m][n+1] == 0) {
                            box[h][m][n+1] = day;
                            int[] arr = {h,m,n+1};
                            deque.add(arr);
                            babyTomato--;adultTomato++;
                        }
                    }
                }
                day++;
            }
            if (babyTomato!=0) {
                bw.write(String.valueOf(-1));
            }
            else {
//                for (int i=0; i<H;i++) {
//                    for (int j=0; j<M;j++) {
//                        for (int k=0; k<N;k++) {
//                            bw.write(String.valueOf(box[i][j][k]));
//                        }
//                        bw.write("\n");
//                    }
//                    bw.write("\n");
//                }
                //처음 1부터 시작하는거 빼고, 마지막에추가되는거 빼고
                bw.write(String.valueOf(day-3));
            }
        }
        bw.close();
    }
}

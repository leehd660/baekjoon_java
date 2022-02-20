package gold5;

import java.io.*;
import java.util.StringTokenizer;

public class G5_14503 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(NMtoken.nextToken());
        int M = Integer.parseInt(NMtoken.nextToken());
        StringTokenizer setting = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(setting.nextToken());
        int y = Integer.parseInt(setting.nextToken());
        int way = Integer.parseInt(setting.nextToken());
        int[][] table = {{3,0,-1,1,0}, {0,-1,0,0,-1}, {1,0,1,-1,0}, {2,1,0,0,1}};
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int count =0;
        while (true) {
            if (map[x][y]==0) {
                map[x][y] = -1;
                count++;
            }
            if (!check(x,y)) {
                if (map[x+table[way][3]][y+table[way][4]] == 1) {
                    break;
                }
                else {
                    x += table[way][3];
                    y += table[way][4];
                }
            }
            else {
                if (map[x + table[way][1]][y + table[way][2]] == 0) {
                    x += table[way][1];
                    y += table[way][2];
                    way = table[way][0];
                } else {
                    way = table[way][0];
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

    static boolean check(int x, int y) {
        //false가 다 막힌 상황
        boolean answer = false;
        int[] xArr = {0,0,1,-1};
        int[] yArr = {1,-1,0,0};
        for (int i=0; i<4; i++) {
            if (map[x+xArr[i]][y+yArr[i]] == 0) {
                answer = true;
                break;
            }
        }
        return answer;
    }
}

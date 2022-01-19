package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_4963 {
    private static int h;
    private static int w;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String mapStr = bf.readLine();
            StringTokenizer mapToken = new StringTokenizer(mapStr);
            w = Integer.parseInt(mapToken.nextToken());
            h = Integer.parseInt(mapToken.nextToken());
            if (w==0 && h==0) {
                break;
            }
            else {
                map = new int[h][w];
                for (int i = 0; i < h; i++) {
                    String wall = bf.readLine();
                    String[] wallArr = wall.split(" ");
                    for (int j = 0; j < w; j++) {
                        map[i][j] = Integer.parseInt(wallArr[j]);
                    }
                }
                int answer = 0;
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (map[i][j] == 1) {
                            map[i][j] = 0;
                            visit(i, j);
                            answer ++;
                        }
                    }
                }
                bw.write(String.valueOf(answer) + "\n");
            }
        }
        bw.close();
    }

    static void visit(int x, int y) {
        if (x > 0) { // 위에 칸이 있는지 확인
            if (map[x - 1][y] == 1) {
                map[x - 1][y] = 0;
                visit(x-1,y);
            }
        }
        if (y > 0) { // 왼쪽으로 갈 수 있는 칸이 있는지 확인
            if (map[x][y - 1] == 1) {
                map[x][y - 1] = 0;
                visit(x,y-1);
            }
        }
        if (x < h - 1) { // 아래쪽으로 갈 수 있는 칸이 있는지 확인
            if (map[x + 1][y] == 1) {
                map[x + 1][y] = 0;
                visit(x+1,y);
            }
        }
        if (y < w - 1) { // 오른쪽으로 갈 수 있는 칸이 있는지 확인
            if (map[x][y+1] == 1) {
                map[x][y + 1] = 0;
                visit(x,y+1);
            }
        }
        if (x<h-1 && y < w - 1) {
            if (map[x+1][y+1] == 1) {
                map[x+1][y + 1] = 0;
                visit(x+1,y+1);
            }
        }
        if (x>0 && y < w - 1) {
            if (map[x-1][y+1] == 1) {
                map[x-1][y + 1] = 0;
                visit(x-1,y+1);
            }
        }
        if (x>0 && y >0) {
            if (map[x-1][y-1] == 1) {
                map[x-1][y-1] = 0;
                visit(x-1,y-1);
            }
        }
        if (x<h-1 && y>0) {
            if (map[x+1][y-1] == 1) {
                map[x+1][y-1] = 0;
                visit(x+1,y-1);
            }
        }
    }
}

package silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1_2667 {
    private static int N;
    private static int[][] land;
    private static List<Integer> house;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        land = new int[N][N];
        for (int i=0; i<N; i++) {
            String wall = bf.readLine();
            String[] wallArr = wall.split("");
            for (int j=0; j<N; j++) {
                land[i][j] = Integer.parseInt(wallArr[j]);
            }
        }
        house = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (land[i][j] == 1) {
                    land[i][j] = 0;
                    house.add(visit(i,j)+1);
                }
            }
        }
        Collections.sort(house);
        bw.write(String.valueOf(house.size())+"\n");
        for (int num : house) {
            bw.write(String.valueOf(num) + "\n");
        }
        bw.close();
    }

    static int visit(int x, int y) {
        //count는 해당 x,y에서 더 갈 수 있는 칸을 세기
        int count = 0;
        if (x > 0) { // 위에 칸이 있는지 확인
            if (land[x - 1][y] == 1) {
                land[x - 1][y] = 0;
                count += visit(x-1, y);
                count++;
            }
        }
        if (y > 0) { // 왼쪽으로 갈 수 있는 칸이 있는지 확인
            if (land[x][y - 1] == 1) {
                land[x][y - 1] = 0;
                count += visit(x, y-1);
                count++;
            }
        }
        if (x < N - 1) { // 아래쪽으로 갈 수 있는 칸이 있는지 확인
            if (land[x + 1][y] == 1) {
                land[x + 1][y] = 0;
                count += visit(x+1, y);
                count++;
            }
        }
        if (y < N - 1) { // 오른쪽으로 갈 수 있는 칸이 있는지 확인
            if (land[x][y+1] == 1) {
                land[x][y + 1] = 0;
                count += visit(x, y+1);
                count++;
            }
        }
        return count;
    }
}

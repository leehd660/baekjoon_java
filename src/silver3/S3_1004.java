package silver3;

import java.io.*;
import java.util.StringTokenizer;

public class S3_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        for (int i=0; i<testNum; i++) {
            String pointStr = bf.readLine();
            StringTokenizer pointToken = new StringTokenizer(pointStr);
            int[] startPoint = {Integer.parseInt(pointToken.nextToken()),Integer.parseInt(pointToken.nextToken())};
            int[] finPoint = {Integer.parseInt(pointToken.nextToken()),Integer.parseInt(pointToken.nextToken())};
            int planetNum = Integer.parseInt(bf.readLine());
            boolean[][] check = new boolean[planetNum][2];
            for (int j=0; j<planetNum; j++) {
                String planetInfo = bf.readLine();
                StringTokenizer planetToken = new StringTokenizer(planetInfo);
                int planetX = Integer.parseInt(planetToken.nextToken());
                int planetY = Integer.parseInt(planetToken.nextToken());
                int round = Integer.parseInt(planetToken.nextToken());
                if (innerCheck(startPoint,planetX,planetY,round)) {
                    check[j][0] = true;
                }
                else {
                    check[j][0] = false;
                }
                if (innerCheck(finPoint,planetX,planetY,round)) {
                    check[j][1] = true;
                }
                else {
                    check[j][1] = false;
                }
            }
            int answer = 0;
            for (int j=0; j<planetNum; j++) {
                if (check[j][0] && !check[j][1]) {
                    answer++;
                }
                else if (!check[j][0] && check[j][1]) {
                    answer++;
                }
            }
            bw.write(String.valueOf(answer)+"\n");
        }
        bw.close();
    }

    static boolean innerCheck(int[] checkPoint, int x, int y, int round) {
        if (Math.pow(checkPoint[0]-x,2)+Math.pow(checkPoint[1]-y,2)>Math.pow(round,2)) {
            return false;
        }
        else {
            return true;
        }
    }
}

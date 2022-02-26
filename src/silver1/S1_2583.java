package silver1;

import java.io.*;
import java.util.*;

public class S1_2583 {
    private static int N;
    private static int M;
    private static int areaSize;
    private static int[][] map;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        for (int i=0; i<K; i++) {
            StringTokenizer squareToken = new StringTokenizer(bf.readLine());
            int startX = Integer.parseInt(squareToken.nextToken());
            int starty = Integer.parseInt(squareToken.nextToken());
            int finX = Integer.parseInt(squareToken.nextToken());
            int finY = Integer.parseInt(squareToken.nextToken());
            for (int x=startX; x<finX; x++) {
                for (int y=starty; y<finY; y++) {
                    if (map[x][y] == 0) {
                        map[x][y] = 1;
                    }
                }
            }
        }
        list = new ArrayList<>();
        int[] xArr = {0,0,1,-1};
        int[] yArr = {1,-1,0,0};
        Deque<Integer> dequeX = new ArrayDeque<>();
        Deque<Integer> dequeY = new ArrayDeque<>();
        areaSize = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    dequeX.add(i);
                    dequeY.add(j);
                    map[i][j] = -1;
                    areaSize++;
                    while (!dequeX.isEmpty()) {
                        int x = dequeX.pollFirst();
                        int y = dequeY.pollFirst();
                        for (int way=0; way<4; way++) {
                            if (x+xArr[way]>=0 && x+xArr[way]<N && y+yArr[way]>=0 && y+yArr[way]<M && map[x+xArr[way]][y+yArr[way]]==0) {
                                map[x+xArr[way]][y+yArr[way]]=-1;
                                areaSize++;
                                dequeX.add(x+xArr[way]);
                                dequeY.add(y+yArr[way]);
                            }
                        }
                    }
                    list.add(areaSize);
                    areaSize=0;
                }
            }
        }
        bw.write(String.valueOf(list.size())+"\n");
        Collections.sort(list);
        for (int i : list) {
            bw.write(String.valueOf(i)+" ");
        }
        bw.close();
    }
}

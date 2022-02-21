package gold5;

import java.io.*;
import java.util.*;

public class G5_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.valueOf(bf.readLine());
        //0은 그냥 땅, 1은 뱀, 2는 사과
        int[][] map = new int[N][N];
        map[0][0] = 1;
        int appleNum = Integer.parseInt(bf.readLine());
        for (int i=0; i<appleNum; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            map[x-1][y-1] = 2;
        }
        int actNum = Integer.parseInt(bf.readLine());
        Map<Integer,String> actMap = new HashMap<>();
        for (int i=0; i<actNum; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(token.nextToken());
            String way = token.nextToken();
            actMap.put(t,way);
        }
        int[] xArr = {0,1,0,-1};
        int[] yArr = {1,0,-1,0};
        Deque<int[]> deque = new ArrayDeque<>();
        int[] startArr = {0,0};
        deque.add(startArr);
        int time = 1;
        int direction = 0;
        while (true) {
            int x = deque.peekFirst()[0];
            int y = deque.peekFirst()[1];
            int[] newArr = {x+xArr[direction], y+yArr[direction]};
            //가려는 방향이 벽이거나 자신의 몸일 때
            if (x+xArr[direction]<0 || x+xArr[direction]>=N || y+yArr[direction]<0
                    || y+yArr[direction]>=N || map[x+xArr[direction]][y+yArr[direction]] == 1){
                break;
            }
            else {
                // 가려는 방향에 사과가 있을 때
                if (map[x + xArr[direction]][y + yArr[direction]] == 2) {
                    map[x + xArr[direction]][y + yArr[direction]] = 1;
                    deque.addFirst(newArr);
                }
                //가려는 방향에 길만 있을 때
                else if (map[x + xArr[direction]][y + yArr[direction]] == 0) {
                    map[x + xArr[direction]][y + yArr[direction]] = 1;
                    deque.addFirst(newArr);
                    map[deque.peekLast()[0]][deque.peekLast()[1]] = 0;
                    deque.pollLast();
                }
            }

            if (actMap.keySet().contains(time)) {
                //방향바꾸기
                if (actMap.get(time).equals("L")) {
                    direction = (direction+3)%4;
                }
                else {
                    direction = (direction+1)%4;
                }
            }
            time++;
        }
        bw.write(String.valueOf(time));
        bw.close();
    }
}

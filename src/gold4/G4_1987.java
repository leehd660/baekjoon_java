package gold4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1987 {
    private static int R;
    private static int C;
    private static int[] xArr;
    private static int[] yArr;
    private static String[][] board;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer RCtoken = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(RCtoken.nextToken());
        C = Integer.parseInt(RCtoken.nextToken());
        board = new String[R][C];
        for (int i=0; i<R; i++) {
            String boardLine = bf.readLine();
            board[i] = boardLine.split("");
        }
        answer = 0;
        xArr = new int[]{0,0,1,-1};
        yArr = new int[]{1,-1,0,0};
        visited = new boolean[26];
        List<String> list = new ArrayList<>();
        list.add(board[0][0]);
        visited[board[0][0].charAt(0) - 'A'] = true;
        DFS(list,0,0);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void DFS(List<String> list, int x, int y) {
        for (int i=0; i<4; i++) {
            if (x+xArr[i]>=0 && x+xArr[i]<R && y+yArr[i]>=0 && y+yArr[i]<C && !visited[board[x+xArr[i]][y+yArr[i]].charAt(0) - 'A']) {
                list.add(board[x+xArr[i]][y+yArr[i]]);
                visited[board[x+xArr[i]][y+yArr[i]].charAt(0) - 'A'] = true;
                DFS(list, x+xArr[i], y+yArr[i]);
                list.remove(list.size()-1);
                visited[board[x+xArr[i]][y+yArr[i]].charAt(0) - 'A'] = false;
            }
        }
        answer = Math.max(answer, list.size());
    }
}

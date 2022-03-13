package gold4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class G4_2580 {
    private static int[][] puzzle;
    private static Deque<Integer> dequeX;
    private static Deque<Integer> dequeY;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        puzzle = new int[9][9];
        dequeX = new ArrayDeque<>();
        dequeY = new ArrayDeque<>();
        for (int i=0; i<9; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<9; j++) {
                puzzle[i][j] = Integer.parseInt(token.nextToken());
                if (puzzle[i][j] == 0) {
                    dequeX.add(i);
                    dequeY.add(j);
                }
            }
        }
        while (!dequeX.isEmpty()) {
            if (checkXLine(dequeX.peekFirst(),dequeY.peekFirst())) {
                dequeX.pollFirst();
                dequeY.pollFirst();
            }
            else if (checkYLine(dequeX.peekFirst(),dequeY.peekFirst())) {
                dequeX.pollFirst();
                dequeY.pollFirst();
            }
            else if (checkSquare(dequeX.peekFirst(), dequeY.peekFirst())) {
                dequeX.pollFirst();
                dequeY.pollFirst();
            }
            else {
                dequeX.add(dequeX.pollFirst());
                dequeY.add(dequeY.pollFirst());
            }
        }
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                bw.write(String.valueOf(puzzle[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static boolean checkXLine (int x, int y) {
        boolean answer = true;
        int count =0;
        boolean[] visited = new boolean[10];
        visited[0] = true;
        for (int i=0; i<9; i++) {
            if (puzzle[x][i] != 0) {
                visited[puzzle[x][i]] = true;
                count++;
            }
        }
        if (count == 8) {
            for (int i=0; i<=9; i++) {
                if (!visited[i]) {
                    puzzle[x][y] = i;
                    break;
                }
            }
        }
        else {
            answer = false;
        }
        return answer;
    }

    static boolean checkYLine (int x, int y) {
        boolean answer = true;
        int count =0;
        boolean[] visited = new boolean[10];
        visited[0] = true;
        for (int i=0; i<9; i++) {
            if (puzzle[i][y] != 0) {
                visited[puzzle[i][y]] = true;
                count++;
            }
        }
        if (count == 8) {
            for (int i=0; i<=9; i++) {
                if (!visited[i]) {
                    puzzle[x][y] = i;
                    break;
                }
            }
        }
        else {
            answer = false;
        }
        return answer;
    }

    static boolean checkSquare (int x, int y) {
        boolean answer = true;
        int count =0;
        boolean[] visited = new boolean[10];
        visited[0] = true;
        for (int i=3*(x/3); i<3*(x/3)+3; i++) {
            for (int j= 3*(y/3); j<3*(y/3)+3; j++) {
                if (puzzle[i][j] != 0) {
                    visited[puzzle[i][j]] = true;
                    count++;
                }
            }
        }
        if (count == 8) {
            for (int i=0; i<=9; i++) {
                if (!visited[i]) {
                    puzzle[x][y] = i;
                    break;
                }
            }
        }
        else {
            answer = false;
        }
        return answer;
    }
}

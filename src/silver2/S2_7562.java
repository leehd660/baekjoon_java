package silver2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S2_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        for (int test=0; test<testNum; test++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] chess = new int[n][n];
            StringTokenizer nowToken = new StringTokenizer(bf.readLine());
            int nowX = Integer.parseInt(nowToken.nextToken());
            int nowY = Integer.parseInt(nowToken.nextToken());
            StringTokenizer wantToken = new StringTokenizer(bf.readLine());
            int wantX = Integer.parseInt(wantToken.nextToken());
            int wantY = Integer.parseInt(wantToken.nextToken());
            if (nowX == wantX && nowY == wantY) {
                bw.write("0\n");
            }
            else {
                Deque<int[]> deque = new ArrayDeque<>();
                int[] now = {nowX, nowY};
                deque.add(now);
                int tryNum = 1;
                while (true) {
                    int count = deque.size();
                    for (int i = 0; i < count; i++) {
                        int x = deque.peekFirst()[0];
                        int y = deque.peekFirst()[1];
                        deque.pollFirst();
                        try {
                            if (chess[x - 1][y + 2] == 0) {
                                chess[x - 1][y + 2] = tryNum;
                                int[] arr = {x - 1, y + 2};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x - 1][y - 2] == 0) {
                                chess[x - 1][y - 2] = tryNum;
                                int[] arr = {x - 1, y - 2};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x + 1][y + 2] == 0) {
                                chess[x + 1][y + 2] = tryNum;
                                int[] arr = {x + 1, y + 2};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x + 1][y - 2] == 0) {
                                chess[x + 1][y - 2] = tryNum;
                                int[] arr = {x + 1, y - 2};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x - 2][y + 1] == 0) {
                                chess[x - 2][y + 1] = tryNum;
                                int[] arr = {x - 2, y + 1};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x - 2][y - 1] == 0) {
                                chess[x - 2][y - 1] = tryNum;
                                int[] arr = {x - 2, y - 1};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x + 2][y + 1] == 0) {
                                chess[x + 2][y + 1] = tryNum;
                                int[] arr = {x + 2, y + 1};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            if (chess[x + 2][y - 1] == 0) {
                                chess[x + 2][y - 1] = tryNum;
                                int[] arr = {x + 2, y - 1};
                                deque.add(arr);
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                    }
                    tryNum++;
                    if (chess[wantX][wantY] != 0) {
                        break;
                    }
                }
                bw.write(String.valueOf(chess[wantX][wantY]) + "\n");
            }
        }
        bw.close();
    }
}

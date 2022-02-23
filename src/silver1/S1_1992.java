package silver1;

import java.io.*;

public class S1_1992 {
    private static String answer;
    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            String str = bf.readLine();
            String[] strArr = str.split("");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        answer = "";
//        answer += "(";
        DFS(N, 0, 0);
//        DFS(N/2, 0, N/2);
//        DFS(N/2, N/2, 0);
//        DFS(N/2, N/2, N/2);
//        answer += ")";
        bw.write(answer);
        bw.close();
    }

    static void DFS (int n, int x, int y) {
        int start = arr[x][y];
        boolean check = true;
        for (int i=x; i<x+n; i++) {
            for (int j=y; j<y+n; j++) {
                if (start != arr[i][j]) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                break;
            }
        }
        if (check) {
            answer += String.valueOf(start);
        }
        else {
            if (n==2) {
                answer += "(";
                for (int i=x; i<x+n; i++) {
                    for (int j=y; j<y+n; j++) {
                        answer += String.valueOf(arr[i][j]);
                    }
                }
                answer += ")";
            }
            else {
                answer += "(";
                DFS(n/2, x, y);
                DFS(n/2, x, y+(n/2));
                DFS(n/2, x+(n/2), y);
                DFS(n/2, x+(n/2), y+(n/2));
                answer += ")";
            }
        }
    }
}

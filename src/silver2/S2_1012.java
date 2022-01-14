package silver2;

import java.io.*;

public class S2_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(bf.readLine());
        for (int caseNum=0; caseNum<testCase; caseNum++) {
            String info = bf.readLine();
            String[] infoArr = info.split(" ");
            int M = Integer.parseInt(infoArr[0]);
            int N = Integer.parseInt(infoArr[1]);
            int K = Integer.parseInt(infoArr[2]);
            int[][] table = new int[N][M];
            for (int i=0; i<K; i++) {
                String locationStr = bf.readLine();
                String[] locationArr = locationStr.split(" ");
                int x = Integer.parseInt(locationArr[1]);
                int y = Integer.parseInt(locationArr[0]);
                table[x][y] = 1;
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (table[i][j] ==1) {
                        if (i>0 && j>0) {
                            table[i][j] += table[i-1][j] + table[i][j-1];
                            table[i-1][j] = 0;
                            table[i][j-1] = 0;
                        }
                        else if (i>0) {
                            table[i][j] += table[i-1][j];
                            table[i-1][j] = 0;
                        }
                        else if (j>0) {
                            table[i][j] += table[i][j-1];
                            table[i][j-1] = 0;
                        }
                    }
                    else {
                        continue;
                    }
                }
            }
            int count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (table[i][j] != 0) {
                        count ++;
                    }
                }
                bw.write("\n");
            }
            bw.write(String.valueOf(count)+"\n");
        }
        bw.close();
    }
}

package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_14889 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        int[][] table = new int[n][n];
        for (int i=0; i<n; i++) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            for (int j=0; j<n; j++) {
                table[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        List<Integer> answerList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
            DFS(list, table, answerList);
            list.remove(list.size()-1);
        }
        int min = 100000;
        for (int i=0; i<answerList.size()/2; i++) {
            int minus = Math.abs(answerList.get(i) - answerList.get(answerList.size()-1-i));
            min = Math.min(minus, min);
        }
        bw.write(String.valueOf(min));
        bw.close();
    }

    static void DFS(List<Integer> list, int[][] table, List<Integer> answerList) {
        if (list.size() == n/2) {
            answerList.add(score(list, table));
        }
        else {
            for (int i=list.get(list.size()-1)+1; i<=n; i++) {
                list.add(i);
                DFS(list,table,answerList);
                list.remove(list.size()-1);
            }
        }
    }

    static int score(List<Integer> list, int[][] table) {
        int answer = 0;
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                int n1 = list.get(i);
                int n2 = list.get(j);
                answer += table[n1-1][n2-1] + table[n2-1][n1-1];
            }
        }
        return answer;
    }
}

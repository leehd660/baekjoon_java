package silver2;

import java.io.*;
import java.util.*;

public class S2_15663 {
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] arr;
    private static List<Integer> dfsList;
    private static List<String> answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NM = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());
        StringTokenizer token = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        answerList = new ArrayList<>();
        dfsList = new ArrayList<>();
        visited = new boolean[N];
        DFS(-1);
        for (String s : answerList) {
            bw.write(s+"\n");
        }
        bw.close();
    }
    static void DFS(int index) {
        if (dfsList.size() == M) {
            StringBuilder answer = new StringBuilder();
            for (int i=0; i<M; i++) {
                answer.append(dfsList.get(i));
                if (i!=M-1) {
                    answer.append(" ");
                }
            }
            if (!answerList.contains(answer.toString())) {
                answerList.add(answer.toString());
            }
        }
        else {
            for (int i=0; i<N; i++) {
                if (!visited[i]) {
                    dfsList.add(arr[i]);
                    visited[i] = true;
                    DFS(i);
                    dfsList.remove(dfsList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}

package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            if ((double)i % Math.sqrt(i) == 0) {
                dp[i] = 1;
                list.add(i);
            }
            else {
                int min = i;
                for (int j=list.size()-1; j>=0; j--) {
                    int num = list.get(j);
                    min = Math.min(dp[num] + dp[i - num],min);
                }
                dp[i] = min;
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
    //DFS문제로 완전 탐색인줄 알았는데 알고보니 DP로 풀이하는 거였음.
//    static int N;
//    static int min;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        N = Integer.parseInt(bf.readLine());
//        int maxNum = (int) Math.sqrt(N);
//        List<Integer> list = new ArrayList<>();
//        min = N;
//        for (int i=maxNum; i>0; i--) {
//            list.add(i);
//            int num = (int)Math.pow(i,2);
//            DFS(list, num);
//            list.remove(list.size()-1);
//        }
//        bw.write(String.valueOf(min));
//        bw.close();
//    }
//
//    static void DFS(List<Integer> list, int total) {
//        if (total == N) {
//            min = Math.min(min, list.size());
//        }
//        else if (list.size() < min) {
//            int num = (int) Math.sqrt(N-total);
//            for (int i=num; i>0; i--) {
//                list.add(i);
//                DFS(list, total + (int) Math.pow(i, 2));
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}

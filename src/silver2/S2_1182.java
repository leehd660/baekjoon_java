package silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_1182 {
    private static int count;
    private static int N;
    private static int S;
    private static long[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NSstr = bf.readLine();
        StringTokenizer NStoken = new StringTokenizer(NSstr);
        N = Integer.parseInt(NStoken.nextToken());
        S = Integer.parseInt(NStoken.nextToken());
        String numStr = bf.readLine();
        StringTokenizer numToken = new StringTokenizer(numStr);
        numArr = new long[N];
        for (int i=0; i<N; i++) {
            numArr[i] = Long.parseLong(numToken.nextToken());
        }
        List<Long> list = new ArrayList<>();
        count=0;
        for (int i=0; i<N; i++) {
            list.add(numArr[i]);
            BFS(list, numArr[i], i);
            list.remove(list.size()-1);
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

    static void BFS(List<Long> list, long total, int index) {
        if (total == S) {
            count++;
        }
        for (int i=index+1; i<N; i++) {
            list.add(numArr[i]);
            total+=numArr[i];
            BFS(list, total, i);
            total-=numArr[i];
            list.remove(list.size()-1);
        }
    }
}

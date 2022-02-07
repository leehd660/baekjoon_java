package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S3_15657 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        StringTokenizer numToken = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(numToken.nextToken());
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            list.add(arr[i]);
            DFS(list, i);
            list.remove(list.size()-1);
        }
        bw.close();
    }
    static void DFS (List<Integer> list, int index) throws IOException {
        if (list.size()==M){
            for (int i : list) {
                bw.write(String.valueOf(i)+" ");
            }
            bw.write("\n");
        }
        else {
            for (int i=index; i<N; i++) {
                list.add(arr[i]);
                DFS(list, i);
                list.remove(list.size()-1);
            }
        }
    }
}

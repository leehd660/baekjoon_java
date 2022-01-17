package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S3_15654 {
    private static int N;
    private static int M;
    private static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String NMstr = bf.readLine();
        StringTokenizer NMst = new StringTokenizer(NMstr);
        N = Integer.parseInt(NMst.nextToken());
        M = Integer.parseInt(NMst.nextToken());
        arr = new int[N];
        String numbers = bf.readLine();
        StringTokenizer numToken = new StringTokenizer(numbers);
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(numToken.nextToken());
        }
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            list.add(arr[i]);
            BFS(list);
            list.remove(list.size()-1);
        }
        bw.close();
    }

    static void BFS(List<Integer> list) throws IOException {
        if (list.size()==M) {
            for (int num : list) {
                bw.write(String.valueOf(num) + " ");
            }
            bw.write("\n");
        }
        else {
            for (int i=0; i<N; i++) {
                if (list.contains(arr[i])){
                    continue;
                }
                else {
                    list.add(arr[i]);
                    BFS(list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}

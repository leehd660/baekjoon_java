package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_10974 {
    private static int[] table;
    private static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(String.valueOf(bf.readLine()));
        table = new int[N];
        for (int i=0; i<N; i++) {
            table[i] = i+1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            list.add(table[i]);
            DFS(list);
            list.remove(list.size()-1);
        }
        bw.close();
    }

    static void DFS(List<Integer> list) throws IOException{
        if (list.size() == N) {
            for (int i=0; i<N; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
        }
        else {
            for (int i=0; i<N; i++) {
                if (list.contains(table[i])) {
                    continue;
                }
                else {
                    list.add(table[i]);
                    DFS(list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}

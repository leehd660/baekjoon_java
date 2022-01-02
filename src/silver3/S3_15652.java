package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_15652 {
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String NMstr = bf.readLine();
        String[] NMarr = NMstr.split(" ");
        N = Integer.parseInt(NMarr[0]);
        M = Integer.parseInt(NMarr[1]);
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            list.add(i);
            DFS(list);
            list.remove(list.size()-1);
        }
        bw.close();
    }

    static void DFS(List<Integer> list) throws IOException {
        if (list.size() == M) {
            for (int i=0; i<M; i++) {
                bw.write(String.valueOf(list.get(i)) + " ");
            }
            bw.write("\n");
        }
        else {
            for (int i=list.get(list.size()-1); i<=N; i++) {
                list.add(i);
                DFS(list);
                list.remove(list.size()-1);
            }
        }
    }
}

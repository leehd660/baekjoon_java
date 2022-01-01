package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);

        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            list.add(i);
            BFS(list);
            list.remove(list.size()-1);
        }
        bw.close();
    }

    static void BFS(List<Integer> list) throws IOException {
        if (list.size() == M) {
            for (int i=0; i<M; i++) {
                bw.write(String.valueOf(list.get(i)) +" ");
            }
            bw.write("\n");
        }
        else {
            for (int i=1; i<=N; i++) {
                list.add(i);
                BFS(list);
                list.remove(list.size()-1);
            }
        }
    }
}

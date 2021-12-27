package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S3_15649 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        for (int i=1; i<=N; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            makeArr(list);
        }
    }

    static void makeArr (List<Integer> list) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (list.size()<M) {
            for (int i = 1; i <= N; i++) {
                if (!list.contains(i)) {
                    list.add(i);
                    makeArr(list);
                    list.remove(list.size()-1);
                }
            }
        }
//        if (list.size()<M) {
//            makeArr(list);
//        }
        else {
            for (int i=0; i<M; i++) {
//                bw.write(String.valueOf(list.get(i))+" ");
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}

package gold5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G5_2110 {
    private static int N;
    private static int C;
    private static int answer;
    private static int[] arr;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NC = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NC.nextToken());
        C = Integer.parseInt(NC.nextToken());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        list = new ArrayList<>();
        answer = 0;
        DFS(-1, arr[N-1]-arr[0]);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void DFS(int index, int distance) {
        if (list.size() == C) {
//            int distance = list.get(C-1) - list.get(0);
//            for (int i=0; i<C-1; i++) {
//                distance = Math.min(distance, list.get(i+1)-list.get(i));
//            }
            answer = Math.max(answer, distance);
        }
        else {
            for (int i=index+1; i<N; i++) {
                int num = distance;
                if (!list.isEmpty()) {
                    num = arr[i]-list.get(list.size()-1);
                }
                list.add(arr[i]);
                DFS(i, Math.min(num, distance));
                list.remove(list.size()-1);
            }
        }
    }
}

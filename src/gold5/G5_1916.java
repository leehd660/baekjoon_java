package gold5;

import java.io.*;
import java.util.*;

public class G5_1916 {
    private static Map<Integer, List<int[]>> map;
    private static int wantEnd;
    private static int sum;
    private static List<Integer> list;
    private static long answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        map = new HashMap<>();
        for (int i=0; i<M; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int startBus = Integer.parseInt(token.nextToken());
            int endBus = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            int[] arr = {endBus,cost};
            if (map.keySet().contains(startBus)) {
                map.get(startBus).add(arr);
            }
            else {
                List<int[]> list = new ArrayList<>();
                list.add(arr);
                map.put(startBus,list);
            }
        }
        StringTokenizer dest = new StringTokenizer(bf.readLine());
        int wantStart = Integer.parseInt(dest.nextToken());
        wantEnd = Integer.parseInt(dest.nextToken());
        sum = 0;
        answer = Long.MAX_VALUE;
        visited = new boolean[N+1];
        list = new ArrayList<>();
        list.add(wantStart);
        DFS();
        bw.write(String.valueOf(answer));
        bw.close();
    }
    static void DFS() {
        if (list.get(list.size()-1) == wantEnd) {
            answer = Math.min(answer, sum);
        }
        else {
            for(int[] arr : map.get(list.get(list.size()-1))) {
                if (!visited[arr[0]]) {
                    list.add(arr[0]);
                    sum += arr[1];
                    visited[arr[0]] = true;
                    DFS();
                    list.add(list.size()-1);
                    sum -= arr[1];
                    visited[arr[0]] = false;
                }
            }
        }
    }
}

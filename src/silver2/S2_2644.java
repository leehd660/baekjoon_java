package silver2;

import java.io.*;
import java.util.*;

public class S2_2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer abToken = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(abToken.nextToken());
        int b = Integer.parseInt(abToken.nextToken());
        int m = Integer.parseInt(bf.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<m; i++) {
            StringTokenizer pbToken = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(pbToken.nextToken());
            int baby = Integer.parseInt(pbToken.nextToken());
            if (map.keySet().contains(parent)) {
                map.get(parent).add(baby);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(baby);
                map.put(parent, list);
            }
            if (map.keySet().contains(baby)) {
                map.get(baby).add(parent);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(parent);
                map.put(baby, list);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        deque.add(a);
        visited[a] = true;
        int answer = 0;
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i=0; i<size; i++) {
                int num = deque.pollFirst();
                if (map.get(num).contains(b)) {
                    answer = count+1;
                    break;
                } else {
                    for (int j : map.get(num)) {
                        if (!visited[j]) {
                            deque.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
            count++;
            if (answer != 0) {
                break;
            }
        }
        if (answer == 0) {
            bw.write(String.valueOf(-1));
        }
        else {
            bw.write(String.valueOf(answer));
        }
        bw.close();
    }
}

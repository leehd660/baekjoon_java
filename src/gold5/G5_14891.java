package gold5;

import java.io.*;
import java.util.*;

public class G5_14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer>[] arr = new List[4];
        for (int i=0; i<4; i++) {
            List<Integer> list = new ArrayList<>();
            String str = bf.readLine();
            for (String s: str.split("")) {
                list.add(Integer.parseInt(s));
            }
            arr[i] = list;
        }
        int num = Integer.parseInt(bf.readLine());
        int answer = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i=0; i<num; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            int wheel = Integer.parseInt(token.nextToken())-1;
            int way = Integer.parseInt(token.nextToken());
            int[] pair = {wheel, way};
            deque.add(pair);
            boolean[] visited = new boolean[4];
            while(!deque.isEmpty()) {
                int[] w = deque.pollFirst();
                visited[w[0]] = true;
                if (w[0]+1 <= 3) {
                    if (arr[w[0]].get(2) != arr[w[0]+1].get(6) && !visited[w[0]+1]) {
                        if (w[1]==1) {
                            int[] innerPair = {w[0]+1, -1};
                            deque.add(innerPair);
                            visited[w[0]+1] = true;
                        }
                        else {
                            int[] innerPair = {w[0]+1, 1};
                            deque.add(innerPair);
                            visited[w[0]+1] = true;
                        }
                    }
                }
                if (w[0]-1 >= 0) {
                    if (arr[w[0]].get(6) != arr[w[0]-1].get(2) && !visited[w[0]-1]) {
                        if (w[1]==1) {
                            int[] innerPair = {w[0]-1, -1};
                            deque.add(innerPair);
                            visited[w[0]-1] = true;
                        }
                        else {
                            int[] innerPair = {w[0]-1, 1};
                            deque.add(innerPair);
                            visited[w[0]-1] = true;
                        }
                    }
                }
                if (w[1] == 1) {
                    arr[w[0]].add(0,arr[w[0]].get(7));
                    arr[w[0]].remove(8);
                }
                else {
                    arr[w[0]].add(arr[w[0]].get(0));
                    arr[w[0]].remove(0);
                }
            }
        }
        for (int i=0; i<4; i++) {
            if (arr[i].get(0)==1) {
                answer+= (int)Math.pow(2,i);
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
//    static int[] check(List<Integer>[] arr) {
//        boolean[] answer = new boolean[4];
//        answer[0] = true;
//        if (arr[0].get(2) == arr[1].get(6)) {
//            answer[1] = false;
//        }
//        if (arr[1].get(2) == arr[2].get(6)) {
//            answer[2] = answer[1];
//        }
//    }
}

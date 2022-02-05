package silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_10819 {
    private static int num;
    private static int answer;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(bf.readLine());
        StringTokenizer numToken = new StringTokenizer(bf.readLine());
        arr = new int[num];
        for (int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(numToken.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[num];
        answer = 0;
        for (int i=0; i<num; i++) {
            list.add(arr[i]);
            visited[i] = true;
            DFS(list, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void DFS (List<Integer> list, boolean[] visited) {
        if (list.size() == num) {
            answer = Math.max(answer, function(list));
        }
        else {
            for (int i=0; i<num; i++) {
                if (visited[i]) {
                    continue;
                }
                else {
                    list.add(arr[i]);
                    visited[i] = true;
                    DFS(list, visited);
                    list.remove(list.size()-1);
                    visited[i] = false;
                }
            }
        }
    }

    static int function(List<Integer> list) {
        int answer = 0;
        for (int i=0; i<list.size()-1; i++) {
            answer += Math.abs(list.get(i)-list.get(i+1));
        }
        return answer;
    }
}

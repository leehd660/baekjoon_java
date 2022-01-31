package silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_14888 {
    private static List<String> funList;
    private static List<String> list;
    private static List<Integer> answerList;
    private static int[] nums;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numbers = Integer.parseInt(bf.readLine());
        nums = new int[numbers];
        StringTokenizer numToken = new StringTokenizer(bf.readLine());
        for (int i=0; i<numbers; i++) {
            nums[i] = Integer.parseInt(numToken.nextToken());
        }
        funList = new ArrayList<>();
        StringTokenizer funToken = new StringTokenizer(bf.readLine());
        for (int i=0; i<4; i++) {
            int funNum = Integer.parseInt(funToken.nextToken());
            for (int j=0; j<funNum; j++) {
                switch (i) {
                    case 0 : funList.add("+"); break;
                    case 1 : funList.add("-"); break;
                    case 2 : funList.add("*"); break;
                    case 3 : funList.add("/"); break;
                }
            }
        }
        list = new ArrayList<>();
        answerList = new ArrayList<>();
        visited = new boolean[funList.size()];
        for (int i=0; i<funList.size(); i++) {
            list.add(funList.get(i));
            visited[i] = true;
            DFS();
            list.remove(list.size()-1);
            visited[i] = false;
        }
        Collections.sort(answerList);
        bw.write(String.valueOf(answerList.get(answerList.size()-1))+"\n");
        bw.write(String.valueOf(answerList.get(0))+"\n");
        bw.close();
    }

    static void DFS () {
        if (list.size()== funList.size()) {
            int answer = nums[0];
            for (int i=0; i<list.size(); i++) {
                switch (list.get(i)) {
                    case "+" : answer += nums[i+1]; break;
                    case "-" : answer -= nums[i+1]; break;
                    case "*" : answer *= nums[i+1]; break;
                    case "/" : answer /= nums[i+1]; break;
                }
            }
            answerList.add(answer);
        }
        else {
            for (int i=0; i<funList.size(); i++) {
                if (!visited[i]) {
                    list.add(funList.get(i));
                    visited[i] = true;
                    DFS();
                    list.remove(list.size()-1);
                    visited[i] = false;
                }
                else {
                    continue;
                }
            }
        }
    }
}

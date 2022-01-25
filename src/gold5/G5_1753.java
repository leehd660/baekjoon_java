package gold5;

import java.io.*;
import java.util.*;

public class G5_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String VEstr = bf.readLine();
        StringTokenizer VEtoken = new StringTokenizer(VEstr);
        int V = Integer.parseInt(VEtoken.nextToken());
        int E = Integer.parseInt(VEtoken.nextToken());
        int startPoint = Integer.parseInt(bf.readLine());
        int[] visited = new int[V+1];
//        short[][] table = new short[V+1][V+1];
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for (int i=0; i<E; i++) {
            String road = bf.readLine();
            StringTokenizer roadToken = new StringTokenizer(road);
            int start = Integer.parseInt(roadToken.nextToken());
            int fin = Integer.parseInt(roadToken.nextToken());
            int weight = Short.parseShort(roadToken.nextToken());
//            if (table[start][fin] == 0) {
//                table[start][fin] = weight;
//            }
//            else {
//                table[start][fin] = (short) Math.min(table[start][fin],weight);
//            }
            if (map.keySet().contains(start)) {
                if (map.get(start).keySet().contains(fin)) {
                    map.get(start).put(fin,Math.min(map.get(start).get(fin),weight));
                }
                else {
                    map.get(start).put(fin,weight);
                }
            }
            else {
                Map<Integer, Integer> innerMap = new HashMap<>();
                innerMap.put(fin,weight);
                map.put(start,innerMap);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(startPoint);
        while (!deque.isEmpty()) {
            //point는 여기서 출발하는 점
            int point = deque.pollFirst();
//            for (int i=1; i<V+1; i++) {
//                if (table[point][i] != 0) {
//                    if (visited[i] == 0) {
//                        visited[i] = visited[point]+table[point][i];
//                        deque.add(i);
//                    }
//                    else {
//                        visited[i] = Math.min(visited[i], visited[point]+table[point][i]);
//                    }
//                }
//            }
            if (map.get(point) != null) {
                for (int key : map.get(point).keySet()) {
                    if (visited[key] == 0) {
                        visited[key] = visited[point] + map.get(point).get(key);
                        deque.add(key);
                    } else {
//                        visited[key] = Math.min(visited[key], visited[point] + map.get(point).get(key));
                        if (visited[key] >= visited[point] + map.get(point).get(key)) {
                            visited[key] = visited[point] + map.get(point).get(key);
                            deque.add(key);
                        }
                    }
                }
            }
        }
        for (int i=1; i<V+1; i++) {
            if (i!=startPoint && visited[i]==0) {
                bw.write("INF\n");
            }
            else {
                bw.write(String.valueOf(visited[i])+"\n");
            }
        }
        bw.close();
    }
}

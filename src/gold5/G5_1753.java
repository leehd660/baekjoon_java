package gold5;

import java.io.*;
import java.util.*;

public class G5_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String VEstr = bf.readLine();
        StringTokenizer VEtoken = new StringTokenizer(VEstr);
        short V = Short.parseShort(VEtoken.nextToken());
        int E = Integer.parseInt(VEtoken.nextToken());
        short startPoint = Short.parseShort(bf.readLine());
        int[] visited = new int[V+1];
//        short[][] table = new short[V+1][V+1];
        Map<Short, Map<Short,Byte>> map = new HashMap<>();
        for (int i=0; i<E; i++) {
            String road = bf.readLine();
            StringTokenizer roadToken = new StringTokenizer(road);
            short start = Short.parseShort(roadToken.nextToken());
            short fin = Short.parseShort(roadToken.nextToken());
            byte weight = Byte.parseByte(roadToken.nextToken());
//            if (table[start][fin] == 0) {
//                table[start][fin] = weight;
//            }
//            else {
//                table[start][fin] = (short) Math.min(table[start][fin],weight);
//            }
            if (map.keySet().contains(start)) {
                if (map.get(start).keySet().contains(fin)) {
                    map.get(start).put(fin, (byte) Math.min(map.get(start).get(fin),weight));
                }
                else {
                    map.get(start).put(fin,weight);
                }
            }
            else {
                Map<Short, Byte> innerMap = new HashMap<>();
                innerMap.put(fin,weight);
                map.put(start,innerMap);
            }
        }
        Deque<Short> deque = new ArrayDeque<>();
        deque.add(startPoint);
        while (!deque.isEmpty()) {
            //point는 여기서 출발하는 점
            short point = deque.pollFirst();
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
                for (short key : map.get(point).keySet()) {
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
        for (short i=1; i<V+1; i++) {
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

package silver2;

import java.io.*;
import java.util.*;

public class S2_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[num];
        int[] sorted = new int[num];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int i=0; i<num; i++) {
            int n = Integer.parseInt(token.nextToken());
            arr[i] = n;
            sorted[i] = n;
        }
        Arrays.sort(sorted);
        int count = 0;
        for (int i : sorted) {
            if (!map.keySet().contains(i)) {
                map.put(i, count);
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }

//    DP방식으로 문제 해결하려 했지만 시간초과 발생
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int num = Integer.valueOf(bf.readLine());
//        Set<Integer> set = new HashSet<>();
//        int[][] arr = new int[num][2];
//        StringTokenizer token = new StringTokenizer(bf.readLine());
//        for (int i=0; i<num; i++) {
//            arr[i][0] = Integer.parseInt(token.nextToken());
//            if (!set.contains(arr[i][0])) {
//                for (int j = i - 1; j >= 0; j--) {
//                    if (arr[i][0] == arr[j][0]) {
//                        arr[i][1] = arr[j][1];
//                        break;
//                    } else if (arr[i][0] > arr[j][0]) {
//                        arr[i][1]++;
//                    } else {
//                        arr[j][1]++;
//                    }
//                }
//                set.add(arr[i][0]);
//            }
//            else {
//                for (int j=i-1; j>=0; j--) {
//                    if (arr[i][0] == arr[j][0]) {
//                        arr[i][1] = arr[j][1];
//                        break;
//                    }
//                }
//            }
//        }
//        for (int i=0; i<num; i++) {
//            bw.write(String.valueOf(arr[i][1])+" ");
//        }
//        bw.close();
//    }
}

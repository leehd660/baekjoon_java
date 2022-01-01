package silver3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class S3_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(bf.readLine());
        for (int i=0; i<testCase; i++) {
            String NMstr = bf.readLine();
            String[] NMarr = NMstr.split(" ");
            int N = Integer.parseInt(NMarr[0]);
            int M = Integer.parseInt(NMarr[1]);
            String str = bf.readLine();
            int[] checkTable = new int[N];
            Integer[] important = new Integer[N];
            int j = 0;
            for (String s : str.split(" ")) {
                checkTable[j] = Integer.parseInt(s);
                important[j] = Integer.parseInt(s);
                j++;
            }
//            SortedMap<Integer, List<Integer>> map = new TreeMap<>();
//            for (String s: str.split(" ")) {
//                int number = Integer.parseInt(s);
//                if (map.keySet().contains(number)) {
//                    map.get(number).add(j);
//                }
//                else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(j);
//                    map.put(number, list);
//                }
//                j++;
//            }
            //중요도 순서로 list만들기
            //원래 int배열 내림차순으로 할 때, Integer[]로 만들어야하나?
            Arrays.sort(important, Collections.reverseOrder());

            Deque<Integer> deque = new ArrayDeque<>();
            for (int k=0; k<N; k++) {
                deque.add(k);
            }
            int count = 0;
            int imIndex = 0;
            while (true) {
                int num = deque.pollFirst();
                if (checkTable[num] == important[imIndex]) {
                    count++;
                    imIndex++;
                    if (num == M) {
                        break;
                    }
                }
                else {
                    deque.add(num);
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }
        bw.close();
    }
}

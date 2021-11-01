package silver4;

import java.io.*;
import java.util.*;

public class S4_2108 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String numStr = bf.readLine();
        int number = scanner.nextInt();
        int[] arr = new int[number];
        Map<Integer,Integer> testMap = new HashMap<>();
        int totalSum = 0;

        for (int i=0; i<number; i++) {
//            String str = bf.readLine();
            int num = scanner.nextInt();
            totalSum += num;
            arr[i] = num;
            if (testMap.containsKey(num)){
                testMap.put(num,testMap.get(num)+1);
            }
            else {
                testMap.put(num,1);
            }
        }
        bw.write(String.valueOf(Math.round((double)totalSum/number)));
        bw.write("\n");
        Arrays.sort(arr);
        bw.write(String.valueOf(arr[number/2]));
        bw.write("\n");
        int compareNum = 0;
        List<Integer> frequency = new ArrayList<>();
        for (int i: testMap.keySet()) {
            if (compareNum<testMap.get(i)){
                compareNum = testMap.get(i);
                frequency.clear();
                frequency.add(i);
            }
            else if (compareNum == testMap.get(i)){
                frequency.add(i);
            }
        }
        Collections.sort(frequency);
        if (frequency.size()>=2){
            bw.write(String.valueOf(frequency.get(1)));
        }
        else {
            bw.write(String.valueOf(frequency.get(0)));
        }
        bw.write("\n");
        bw.write(String.valueOf(arr[number-1]-arr[0]));
        bw.close();
    }
}

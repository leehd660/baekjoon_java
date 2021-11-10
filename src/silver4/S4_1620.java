package silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        String[] arr = new String[Integer.parseInt(numArr[0])];
//        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<Integer.parseInt(numArr[0]); i++) {
            String pocketmon = bf.readLine();
            arr[0] = pocketmon;
//            map.put(pocketmon,i+1);
        }
        for (int i = 0; i<Integer.parseInt(numArr[1]); i++) {
            String test = bf.readLine();
            try {
                int num = Integer.parseInt(test);
                for (String s : map.keySet()) {
                    if (num == map.get(s)) {
                        bw.write(s);
                        bw.write("\n");
                    }
                }
            }
            catch (NumberFormatException nfe) {
                int answer = map.get(test);
                bw.write(String.valueOf(answer));
                bw.write("\n");
            }
        }
        bw.close();
    }
//    static class Pocketmon {
//        String name;
//        int id;
//        Pocketmon (String name, int id) {
//            this.name = name;
//            this.id = id;
//        }
//    }
    int binary (int key, int min, int max) {
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;

            if(key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}

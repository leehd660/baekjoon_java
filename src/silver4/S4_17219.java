package silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numbers = bf.readLine();
        String[] numArr = numbers.split(" ");
        int totalNum = Integer.parseInt(numArr[0]);
        int findNum = Integer.parseInt(numArr[1]);
        Map<String, String> memo = new HashMap<>();
        for (int i=0; i<totalNum; i++) {
            String line = bf.readLine();
            String[] arr = line.split(" ");
            memo.put(arr[0], arr[1]);
        }
        for (int i=0; i<findNum; i++) {
            String findSite = bf.readLine();
            String password = memo.get(findSite);
            bw.write(password + "\n");
        }
        bw.close();
    }
}

package silver4;

import java.io.*;
import java.util.Arrays;

public class S4_1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String tableStr = bf.readLine();
        int[] table = new int[num];
        int count = 0;
        for (String s : tableStr.split(" ")){
            table[count] = Integer.parseInt(s);
            count++;
        }
        int[] keepTable = new int[num];
        for (int j=0; j<num; j++) {
            keepTable[j] = table[j];
        }
        Arrays.sort(table);
        int[] bTable = new int[num];
        boolean[] test = new boolean[num];
        int count2 = 0;
        for (int n : table) {
            for (int j=0; j<num; j++) {
                if (keepTable[j] == n && !test[j]) {
                    bTable[j] = count2;
                    test[j] = true;
                    count2++;
                    break;
                }
            }
        }
        for (int number : bTable) {
            bw.write(String.valueOf(number) + " ");
        }
        bw.close();
    }
}

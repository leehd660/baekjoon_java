package silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S2_6603 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bf.readLine();
            if (str.equals("0")) break;
            else {
                String[] arr = str.split(" ");
                int[] numArr = new int[Integer.parseInt(arr[0])];
                for (int i=1; i<arr.length; i++) {
                    numArr[i-1] = Integer.parseInt(arr[i]);
                }
                List<Integer> list = new ArrayList<>();
                for (int i=0; i< numArr.length; i++) {
                    list.add(numArr[i]);
                    DFS(numArr, list, i);
                    list.remove(list.size()-1);
                }
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void DFS (int[] table, List<Integer> list, int index) throws IOException {
        if (list.size()==6) {
            for (int i : list) {
                bw.write(String.valueOf(i) + " ");
            }
            bw.write("\n");
        }
        else {
            for (int i=index+1; i<table.length; i++) {
                list.add(table[i]);
                DFS(table, list, i);
                list.remove(list.size()-1);
            }
        }
    }
}

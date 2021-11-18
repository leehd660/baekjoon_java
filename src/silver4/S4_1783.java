package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S4_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String size = bf.readLine();
        String[] sizeArr = size.split(" ");
        int N = Integer.parseInt(sizeArr[0]);
        int M = Integer.parseInt(sizeArr[1]);
        List<List> bigTable = new ArrayList<>();
        List<int[]> smallTable = new ArrayList<>();
        int[] first = {1,1};
        smallTable.add(first);
        bigTable.add(smallTable);
        int count =1;
        while (!bigTable.get(bigTable.size()-1).isEmpty()){
            List<int[]> list = new ArrayList<>();
            for (int i=0; i<bigTable.get(bigTable.size()-1).size(); i++) {
                int[] arr = (int[]) bigTable.get(bigTable.size()-1).get(i);
                if (arr[0]+1 < N && arr[1]+2 < M) {
                    int[] newArr = {arr[0]+1,arr[1]+2};
                    list.add(newArr);
                }
                if (arr[0]+2< N && arr[1]+1 < M) {
                    int[] newArr = {arr[0]+2,arr[1]+1};
                    list.add(newArr);
                }
                if (arr[0]-2 < N && arr[1]+1 < M && arr[0]-2 >= 1) {
                    int[] newArr = {arr[0]-2,arr[1]+1};
                    list.add(newArr);
                }
                if (arr[0]-1 < N && arr[1]+2 < M && arr[0]-2 >= 1) {
                    int[] newArr = {arr[0]-1,arr[1]+2};
                    list.add(newArr);
                }
            }
            bigTable.add(list);
            if (!list.isEmpty()){
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}

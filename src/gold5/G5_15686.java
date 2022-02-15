package gold5;

import java.io.*;
import java.util.*;

public class G5_15686 {
    private static int N;
    private static int M;
    private static List<int[]> houseList;
    private static List<int[]> chickenList;
    private static int[][] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NMtoken = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
//        int homeCount = 0;
//        int chickenCount = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer partCity = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(partCity.nextToken());
                switch (num) {
                    case 0 : break;
                    case 1 : int[] address1 = {i,j}; houseList.add(address1); break;
                    case 2 : int[] address2 = {i,j}; chickenList.add(address2); break;
                }
            }
        }
        arr = new int[houseList.size()][chickenList.size()];
        for (int h=0; h<houseList.size(); h++) {
            for (int c=0; c<chickenList.size(); c++) {
                arr[h][c] = Math.abs(houseList.get(h)[0]-chickenList.get(c)[0])+Math.abs(houseList.get(h)[1]-chickenList.get(c)[1]);
            }
        }
        List<Integer> list = new ArrayList<>();
        answer = 1000000000;
        for (int i=0; i<chickenList.size(); i++) {
            list.add(i);
            DFS(list, i);
            list.remove(list.size()-1);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static void DFS (List<Integer> list, int index) {
        if (list.size()==M) {
            int total = 0;
            for (int i=0; i<houseList.size(); i++) {
                int minChicken = 2*N;
                for (int j=0; j<list.size(); j++) {
                    minChicken = Math.min(minChicken, arr[i][list.get(j)]);
                }
                total += minChicken;
            }
            answer = Math.min(total, answer);
        }
        else {
            for (int i=index+1; i<chickenList.size(); i++) {
                list.add(i);
                DFS(list, i);
                list.remove(list.size()-1);
            }
        }
    }
}

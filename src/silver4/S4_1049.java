package silver4;

import java.io.*;
import java.util.Arrays;

public class S4_1049 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String mnStr = bf.readLine();
        String[] mnArr = mnStr.split(" ");
        int N = Integer.parseInt(mnArr[0]);
        int M = Integer.parseInt(mnArr[1]);
        int[] packArr = new int[M];
        int[] unitArr = new int[M];
        for (int i=0; i<M; i++) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            int pack = Integer.parseInt(strArr[0]);
            int unit = Integer.parseInt(strArr[1]);
            packArr[i] = pack;
            unitArr[i] = unit;
        }
        Arrays.sort(packArr);
        Arrays.sort(unitArr);
        int answer = count(N,packArr[0],unitArr[0]);
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static int count(int N, int pack, int unit) {
        int num = N/6;
        int minMoney = N*unit;
        for (int i=0; i<=num; i++) {
            int compareMoney = 0;
            compareMoney += i*pack;
            compareMoney += (N-(6*i))*unit;
            if (minMoney>compareMoney) {
                minMoney = compareMoney;
            }
        }
        if ((num+1)*pack < minMoney){
            minMoney = (num+1)*pack;
        }
        return minMoney;
    }
}

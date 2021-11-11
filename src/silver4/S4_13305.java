package silver4;

import java.io.*;
import java.math.BigInteger;

public class S4_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String cityNumStr = bf.readLine();
        int cityNum = Integer.parseInt(cityNumStr);
        String distanceStr = bf.readLine();
        String[] distStrArr = distanceStr.split(" ");
        BigInteger[] distance = new BigInteger[cityNum-1];
        for (int i=0; i<cityNum-1; i++) {
            distance[i] = BigInteger.valueOf(Long.valueOf(distStrArr[i]));
        }
        String costStr = bf.readLine();
        String[] costStrArr = costStr.split(" ");
        BigInteger[] cost = new BigInteger[cityNum];
        for (int i=0; i<cityNum; i++) {
            cost[i] = BigInteger.valueOf(Long.valueOf(costStrArr[i]));
        }

        BigInteger answer =BigInteger.ZERO;
        BigInteger minCost = cost[0];
        for (int i=0; i<cityNum-1; i++) {
            if ( i == 0 ){
                answer = answer.add(distance[i].multiply(minCost));
            }
            else {
                if (minCost.compareTo(cost[i]) <= 0){
                    minCost = minCost;
                }
                else {
                    minCost = cost[i];
                }
                answer = answer.add(distance[i].multiply(minCost));
            }

        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

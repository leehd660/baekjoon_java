package silver5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 숫자야구 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        List<Integer> table = new ArrayList<>();
        Map<Integer, Boolean> table = new HashMap<>();
        for (int a=1; a<10; a++){
            for (int b=1; b<10; b++){
                for (int c=1; c<10; c++){
                    if (a!=b && b!=c && c!=a) {
                        int num = 100*a + 10*b + c;
                        table.put(num,true);
                    }
                }
            }
        }
        String strNum = bf.readLine();
        int num = Integer.parseInt(strNum);
        for (int i=0; i<num; i++) {
            String test = bf.readLine();
            String[] testArr = test.split(" ");
            int testNum = Integer.parseInt(testArr[0]);
            int ta = testNum%10;
            int tb = (testNum/10)%10;
            int tc = testNum/100;
            int S = Integer.parseInt(testArr[1]);
            int B = Integer.parseInt(testArr[2]);
            for (int N : table.keySet()){
                int countS = 0;
                int countB = 0;
//                int N = table.get(k);
                int a = N%10;
                int b = (N/10)%10;
                int c = N/100;
                if (a==ta) countS++;
                if (b==tb) countS++;
                if (c==tc) countS++;
                if (a==tb) countB++;
                if (a==tc) countB++;
                if (b==ta) countB++;
                if (b==tc) countB++;
                if (c==ta) countB++;
                if (c==tb) countB++;
                if (table.get(N) && countB == B && countS == S){
                    continue;
                }
                else {
                    table.put(N,false);
                }
            }
        }
        int answer = 0;
        for (int a : table.keySet()){
            if (table.get(a)){
                answer ++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

package silver5;

import java.io.*;

public class S5_2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nmStr = bf.readLine();
        String[] nmArr = nmStr.split(" ");
        int N = Integer.parseInt(nmArr[0]);
        int M = Integer.parseInt(nmArr[1]);
        int[][] check = new int[M][2];
        for (int i=0; i<M; i++) {
            String notaste = bf.readLine();
            String[] notasteArr = notaste.split(" ");
            int a = Integer.parseInt(notasteArr[0]);
            int b = Integer.parseInt(notasteArr[1]);
            check[i][0] = a;
            check[i][1] = b;
        }
//        int count =0;
        int answer =0;
        for (int i=1; i<=N-2; i++) {
            for (int j=i+1; j<=N-1; j++) {
                for (int k=j+1; k<=N; k++) {
                    if (test(check,i,j,k)){
                        continue;
                    }
                    else {
                        answer ++;
                    }
                }
            }
        }
//        for (int i=1; i<=N; i++) {
//            boolean test = false;
//            for (int j=0; j<M; j++) {
//                if (check[j][0] == i || check[j][1] == i) {
//                    test = true;
//                    count++;
//                }
//            }
//            if (test) {
//                count--;
//            }
//        }
//        int answer = ((N*(N-1)*(N-2))/6) - ((N-2)*M) + count;
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static boolean test(int[][] table, int a,int b,int c){
        boolean answer = false;
        for (int i=0; i<table.length; i++) {
            if ( (table[i][0] == a || table[i][0] == b || table[i][0] == c) && (table[i][1] == a || table[i][1] == b || table[i][1] == c)){
                answer = true;
                break;
            }
        }
        return answer;
    }
}

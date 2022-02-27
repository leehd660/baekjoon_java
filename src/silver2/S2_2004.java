package silver2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int count2 = find2(n) - find2(n-m) - find2(m);
        int count5 = find5(n) - find5(n-m) - find5(m);
        int answer = Math.min(count2, count5);
        if (answer>0) {
            bw.write(String.valueOf(answer));
        }
        else {
            bw.write("0");
        }
        bw.close();
    }
    static int find2 (int num) {
        int answer = 0;
        while (num>=2) {
            answer += num/2;
            num /= 2;
        }
        return answer;
    }
    static int find5 (int num) {
        int answer = 0;
        while (num>=5) {
            answer += num/5;
            num /= 5;
        }
        return answer;
    }


//    처음에 5와 2의 개수를 구하면 문제를 빨리 풀 수 있을 거라 생각했는데 시간초과가 발생함. -> 팩토리얼에서 제곱되는 수를 구하는 방법 터득

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer token = new StringTokenizer(bf.readLine());
//        int n = Integer.parseInt(token.nextToken());
//        int m = Integer.parseInt(token.nextToken());
//        int upCount5 = 0;
//        int doCount5 = 0;
//        int upCount2 = 0;
//        int doCount2 = 0;
//        for (int i=n; i>=n-m+1; i--) {
//            if (i%5==0) {
//                int copy = i;
//                while (copy%5==0) {
//                    copy /= 5;
//                    upCount5++;
//                }
//            }
//            if (i%2==0) {
//                int copy = i;
//                while (copy%2==0) {
//                    copy /= 2;
//                    upCount2++;
//                }
//            }
//        }
//        for (int i=m; i>=1; i--) {
//            if (i%5==0) {
//                int copy = i;
//                while (copy%5==0) {
//                    copy /= 5;
//                    doCount5++;
//                }
//            }
//            if (i%2==0) {
//                int copy = i;
//                while (copy%2==0) {
//                    copy /= 2;
//                    doCount2++;
//                }
//            }
//        }
//        int answer = Math.min(upCount5-doCount5, upCount2-doCount2);
//        if (answer>0) {
//            bw.write(String.valueOf(answer));
//        }
//        else {
//            bw.write("0");
//        }
//        bw.close();
//    }
}

package silver5;

import java.util.Scanner;

public class 소수 {
    public static void main(String[] args) {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String num1 = bf.readLine();
//        String num2 = bf.readLine();
//        int M = Integer.parseInt(num1);
//        int N = Integer.parseInt(num2);
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int total = 0;
        int min = 0;
        if (M<=2 && N>=2){
            total += 2;
            min = 2;
            M=3;
        }
        else if (M % 2 == 0) {
            M++;
        }
        for (int i = M; i <= N; i += 2) {
            boolean answer = true;
            if (i == 1) {
                continue;
            }
            if (i==3) {
                total += 3;
                if (min == 0) {
                    min = 3;
                }
                continue;
            }
            for (int j = 3; j < Math.sqrt(i+1); j += 2) {
                if (i % j == 0) {
                    answer = false;
                    break;
                }
            }
            if (answer == true) {
                total += i;
                if (min == 0) {
                    min = i;
                }
            }

        }
        if (total == 0) {
//            bw.write("-1");
            System.out.println(-1);
        } else {
//            bw.write(String.valueOf(total) + '\n' + String.valueOf(min));
            System.out.println(total);
            System.out.println(min);
        }
//        bw.close();
    }
}

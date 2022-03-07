package gold5;

import java.util.Scanner;

public class G5_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N%2 == 1) {
            System.out.println(0);
        }
        else {
            int[] dp = new int[N/2];
            dp[0] = 3;
            for (int i=1; i<N/2; i++) {
                dp[i] = dp[i-1]*3+2;
                for (int j=0; j<i-1; j++) {
                    dp[i] += dp[j]*2;
                }
            }
            System.out.println(dp[N/2-1]);
        }
    }
}

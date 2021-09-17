package bronze3;

import java.math.BigInteger;
import java.util.Scanner;

public class 지수연산 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger bigNum = two.pow(n);
        double answer = one.divide(bigNum);
        System.out.println(answer);

    }
}

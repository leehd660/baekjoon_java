package silver5;

import java.math.BigInteger;
import java.util.Scanner;

public class 수들의합 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long s = scanner.nextLong();
//        BigInteger answer = BigInteger.valueOf(0);
//        BigInteger S = BigInteger.valueOf(s);
//        BigInteger S2 = S.multiply(BigInteger.valueOf(2));
//        BigInteger B = S2.sqrt();
//        if (s==3 || s==4) {
//            answer = BigInteger.valueOf(2);
//        }
//        if (B.remainder(BigInteger.valueOf(1)).equals(BigInteger.valueOf(0))){
//            answer = B.subtract(BigInteger.valueOf(1));
//        }
//        else {
//            answer = B.subtract(B.remainder(BigInteger.valueOf(1)));
//        }
//        System.out.println(answer);

        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong();
        long count =0;
        BigInteger total = BigInteger.valueOf(0);
        long answer = 0;
        if (s == 1 || s==2) {
            answer = 1;
        }
        for (long i = 1; i<s; i++){
            total = total.add(BigInteger.valueOf(i));
            count ++;
            if (total.equals(BigInteger.valueOf(s))){
                answer = count;
                break;
            }
            else if (total.compareTo(BigInteger.valueOf(s))==1) {
                answer = count-1;
                break;
            }
        }
        System.out.println(answer);
    }
}

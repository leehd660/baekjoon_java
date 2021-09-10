package bronze3;

import java.math.BigInteger;
import java.util.Scanner;

public class 부호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[3];
        for(int j=0; j<3; j++){
            int n = scanner.nextInt();

            BigInteger answer = new BigInteger("0");
            for (int i=0; i<n; i++){
                BigInteger a = scanner.nextBigInteger();
                answer = answer.add(a);
            }
            if (answer.compareTo(BigInteger.valueOf(0))==1){
                arr[j]="+";
            }
            else if (answer.compareTo(BigInteger.valueOf(0))==-1) {
                arr[j]="-";
            }
            else {
                arr[j]="0";
            }
            answer =BigInteger.valueOf(0);
        }
        for (String s:arr){
            System.out.println(s);
        }

    }
}

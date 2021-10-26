package silver4;

import java.util.Scanner;

public class S4_1978 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int answerCount = 0;
        for (int i=0; i<num; i++) {
            int testNum = scanner.nextInt();
            if (test(testNum)){
                answerCount ++;
            }
        }
        System.out.println(answerCount);
    }

    static boolean test(int n) {
        boolean answer = true;
        if (n==1){
            answer = false;
        }
        else if (n==2) {
            answer = true;
        }
        else if (n%2==0){
            answer = false;
        }
        else {
            for (int i=3; i<=Math.sqrt(n); i+=2) {
                if (n%i==0){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}

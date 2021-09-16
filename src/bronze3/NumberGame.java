package bronze3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howMany = scanner.nextInt();
        List<Integer> answerArr = new ArrayList<>();

        for (int i=0; i<howMany; i++) {
            int realN = scanner.nextInt();
            int n = realN;
            int count = 0;
            for (int j=2; j<realN+1; j++){
                if (n%j==0){
                    count++;
                    n = n/j;
                    System.out.println(j+"gg");
                    j--;
                }
                else {
                    n = realN;
                }
            }
        answerArr.add(count);
        }

        for (int i : answerArr){
            System.out.println(i);
        }
    }
}

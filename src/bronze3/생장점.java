package bronze3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 생장점 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> answerList = new ArrayList<>();
        while (true) {
            int yearNum = scanner.nextInt();
            if (yearNum ==0) {
                break;
            }
            else {
                int branchNum = 1;
                for (int i=0; i<yearNum; i++){
                    int splitbranch = scanner.nextInt();
                    int cutbrannch = scanner.nextInt();
                    branchNum = (branchNum*splitbranch)-cutbrannch;
                }
                answerList.add(branchNum);
            }
        }
        for (int i:answerList){
            System.out.println(i);
        }
    }
}

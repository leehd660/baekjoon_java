package bronze1;

import java.util.Scanner;

public class 평균 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int totalScore = 0;
        int maxNum = 0;
        for (int i=0; i<num; i++){
            int a= scanner.nextInt();
            totalScore+=a;
            if (a>maxNum){
                maxNum=a;
            }
            System.out.println(totalScore);
        }
        double answer = (((double)totalScore/maxNum)*100)/num;
        System.out.println(answer);
    }
}

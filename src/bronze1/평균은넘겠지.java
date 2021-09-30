package bronze1;

import java.util.Scanner;

//@SuppressWarnings("unchecked")
public class 평균은넘겠지 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int classNum = scanner.nextInt();
        String[] classArr = new String[classNum];

        for (int i=0; i<classNum; i++){
            int stuNum = scanner.nextInt();
            int totalNum = 0;
            int[] arr = new int[stuNum];
            for (int j=0; j<stuNum; j++){
                int score = scanner.nextInt();
                arr[j] = score;
                totalNum += score;
            }
            double m = (double) totalNum /stuNum;
            int count = 0;
            for (int ans : arr){
                if (ans>m){
                    count += 1;
                }
            }
            double percent = ((double)count/stuNum)*100;
            classArr[i] = String.format("%.3f",percent) + "%";
        }
        for (String s : classArr){
            System.out.println(s);
        }
    }
}

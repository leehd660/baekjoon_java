package bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class 데이트 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String manName = scanner.next();
        int n = scanner.nextInt();
        String[] girlArr = new String[n];
        String maxLove = "";
        long maxScore = 0;

        for (int i=0; i<n; i++){
            girlArr[i] = scanner.next();
        }
        Arrays.sort(girlArr);


        for (String girlName : girlArr){
            long compareNum = loVe(manName,girlName);
            if (maxLove.equals("")){
                maxLove = girlName;
                maxScore = compareNum;
            }
            if (compareNum>maxScore){
                maxLove = girlName;
                maxScore = compareNum;
            }
        }
        System.out.println(maxLove);
    }

    public static long loVe(String a, String b){
        long LNum = countChar(a,'L') + countChar(b,'L');
        long ONum = countChar(a,'O') + countChar(b,'O');
        long VNum = countChar(a,'V') + countChar(b,'V');
        long ENum = countChar(a,'E') + countChar(b,'E');
        return ((LNum+ONum)*(LNum+VNum)*(LNum+ENum)*(ONum+VNum)*(ONum+ENum)*(VNum+ENum))%100;
    }

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}

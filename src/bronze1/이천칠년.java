package bronze1;

import java.util.Scanner;

public class 이천칠년 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int date = scanner.nextInt();
        scanner.close();
        int[] monDayNum = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] whatday = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int totalday=0;

        for (int i=1; i<month;i++){
            totalday += monDayNum[i-1];
        }
        totalday += date;
        int answer = (totalday%7);
        System.out.println(whatday[answer]);
    }
}

package bronze1;

import java.util.Scanner;

public class 연도진행바 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.next();
        String day = scanner.next();
        int year = scanner.nextInt();
        String nowTime = scanner.next();
        int[] normalYear = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] specialYear = {31,29,31,30,31,30,31,31,30,31,30,31};

        int monthNum = 0;
        switch (month) {
            case "January" : monthNum=1; break;
            case "February" : monthNum=2; break;
            case "March" : monthNum=3; break;
            case "April" : monthNum=4; break;
            case "May" : monthNum=5; break;
            case "June" : monthNum=6; break;
            case "July" : monthNum=7; break;
            case "August" : monthNum=8; break;
            case "September" : monthNum=9; break;
            case "October" : monthNum=10; break;
            case "November" : monthNum=11; break;
            case "December" : monthNum=12; break;
        }
        String[] Day = day.split(",");
        int realDay = Integer.parseInt(Day[0]);
        long time = 0;
        String[] timeChan = nowTime.split(":");
        for (int i=0; i<2; i++){
            time += Integer.parseInt(timeChan[i]) * Math.pow(60,1-i);
        }

        long totalMin = 0;
        long ingMin =0;
        if (yearCheck(year)){
            totalMin = 365*24*60;
            for (int i=1; i<monthNum; i++){
                ingMin += normalYear[i-1]*24*60;
            }
            ingMin += (realDay-1)*24*60;
            ingMin += time;
        }
        else {
            totalMin = 366*24*60;
            for (int i=1; i<monthNum; i++){
                ingMin += specialYear[i-1]*24*60;
            }
            ingMin += (realDay-1)*24*60;
            ingMin += time;
        }
        System.out.println(ingMin +"gg"+totalMin);
        double answer = ((double) ingMin/(double)totalMin)*100;
        System.out.println(answer);
    }

    public static boolean yearCheck(int y){
        boolean answer = true;
        if (y%400==0){
            //윤년
            answer = false;
        }
        else if (y%100==0){
            //평년
            answer = true;
        }
        else if (y%4==0){
            //윤년
            answer = false;
        }
        else {
            //평년
            answer = true;
        }
        return answer;
    }
}

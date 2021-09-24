package bronze1;

import java.util.Scanner;

public class 디데이 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int to_y = scanner.nextInt();
        int to_m = scanner.nextInt();
        int to_d = scanner.nextInt();
        int Dd_y = scanner.nextInt();
        int Dd_m = scanner.nextInt();
        int Dd_d = scanner.nextInt();
        scanner.close();
        int[] normalYear = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] specialYear = {31,29,31,30,31,30,31,31,30,31,30,31};
        long answer = 0;
        long start = 0;
        long fin = 0;

        if (year(to_y)){
            for(int i=1; i<to_m; i++){
                start += normalYear[i-1];
            }
            start += to_d;
        }
        else {
            for(int i=1; i<to_m; i++){
                start += specialYear[i-1];
            }
            start += to_d;
        }

        // 디데이 세는 날 세기
        if (to_y==Dd_y){
            if (year(to_y)){
                for(int i=1; i<Dd_m; i++){
                    fin += normalYear[i-1];
                }
                fin += Dd_d;
            }
            else {
                for(int i=1; i<Dd_m; i++){
                    fin += specialYear[i-1];
                }
                fin += Dd_d;
            }
        }
        else {
            for (int i=to_y; i<Dd_y; i++){
                if (year(i)){
                    fin += 365;
                }
                else {
                    fin += 366;
                }
            }
            if (year(Dd_y)){
                for(int i=1; i<Dd_m; i++){
                    fin += normalYear[i-1];
                }
                fin += Dd_d;
            }
            else {
                for(int i=1; i<Dd_m; i++){
                    fin += specialYear[i-1];
                }
                fin += Dd_d;
            }
        }
        answer = fin-start;
        if (answer < 365243) {
            System.out.println("D-" + answer);
        }
        else{
            System.out.println("gg");
        }

    }
    public static boolean year(int y){
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

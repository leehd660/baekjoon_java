package silver5;

import java.util.Scanner;

public class 체스판다시칠하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[][] arr = new String[N][M];
        for (int i=0; i<N; i++){
            String s = scanner.next();
            arr[i]  = s.split("");
        }
        int min = 64;
        for (int i=7; i<N; i++){
            for (int j=7; j<M; j++){
                int num = colorCheck(i,j,arr);
                if (min>num){
                    min =num;
                }
            }
        }
        System.out.println(min);
    }

    static int colorCheck(int x,int y,String[][] arr){
        int answer =0;
        int answer1 =0;
        int answer2=0;
        int count1=0;
        int count2=0;
        for (int i=x-7; i<=x; i++){
            for (int j=y-7; j<=y; j++){
                //왼쪽 위가 W일때
                if (count1%2==0){
                    if (arr[i][j].equals("W")){
                        answer1++;
                    }
                }
                else {
                    if (arr[i][j].equals("B")){
                        answer1++;
                    }
                }
                count1++;
            }
            count1++;
        }
        for (int i=x-7; i<=x; i++){
            for (int j=y-7; j<=y; j++){
                //왼쪽 위가 B일때
                if (count2%2==0){
                    if (arr[i][j].equals("B")){
                        answer2++;
                    }
                }
                else {
                    if (arr[i][j].equals("W")){
                        answer2++;
                    }
                }
                count2++;
            }
            count2++;
        }
        answer = 64-(Math.max(answer1,answer2));
        return answer;
    }
}

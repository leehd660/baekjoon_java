package bronze1;

import java.util.Scanner;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] stuArr = new int[n][5];
        for (int i=0; i<n; i++){
            for (int j=0; j<5; j++){
                stuArr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int bigStu = 1;
        int bigNum = 0;
        for (int i=0; i<n; i++){
            int count =0;
            for (int j=0; j<n; j++){
                if (i==j){
                    continue;
                }
                else{
                    for (int k=0; k<5; k++) {
                        if (stuArr[i][k] == stuArr[j][k]){
                             count++;
                             break;
                        }
                    }
                }
            }
            if (count > bigNum) {
                bigStu = i+1;
                bigNum = count;
            }
        }
        System.out.println(bigStu);
    }
}

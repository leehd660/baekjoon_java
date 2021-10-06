package bronze1;

import java.util.Scanner;

public class 이차원배열의합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        for (int a=0; a<row; a++){
            for (int b=0; b<col; b++){
                arr[a][b]=scanner.nextInt();
            }
        }
        int findNum = scanner.nextInt();
        for (int a=0; a<findNum; a++){
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(addArr(i,j,x,y,arr));
        }
    }

    static long addArr(int i, int j, int x, int y, int[][] arr){
        long total = 0;
        for (int a=i; a<=x; a++){
            for (int b=j; b<=y; b++){
                total += arr[a-1][b-1];
            }
        }
        return total;
    }
}

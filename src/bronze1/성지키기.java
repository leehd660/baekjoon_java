package bronze1;

import java.util.Scanner;

public class 성지키기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[][] castleArr = new String[n][m];

        for (int i =0;  i<n; i++){
            String row = scanner.next();
            String[] rowArr = row.split("");
            for (int j=0; j<m; j++){
                castleArr[i][j] = rowArr[j];
            }
        }

        int rowAns = 0;
        int colAns = 0;

        for (int i=0; i<n; i++) {
            int count =0;
            for (int j=0; j<m; j++) {
                if (castleArr[i][j].equals("X")){
                    count++;
                }
            }
            if (count>0){
                continue;
            }
            else{
                rowAns ++;
            }
        }

        for (int i=0; i<m; i++) {
            int count =0;
            for (int j=0; j<n; j++) {
                if (castleArr[j][i].equals("X")){
                    count++;
                }
            }
            if (count>0){
                continue;
            }
            else{
                colAns++;
            }
        }

        System.out.println(Math.max(colAns,rowAns));;
    }
}

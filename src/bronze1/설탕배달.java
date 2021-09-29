package bronze1;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sugar = scanner.nextInt();
        scanner.close();
        int answer = 0;


        for (int i=0; i<(sugar/5)+1; i++){
            for (int j=0; j<(sugar/3)+1; j++){
                if (sugar == i*5 + j*3){
                    int compareNum = i+j;
                    if (answer==0 || compareNum<answer){
                        answer = compareNum;
                    }
                }
            }
        }
        if (answer==0){
            answer = -1;
        }
        System.out.println(answer);
    }
}

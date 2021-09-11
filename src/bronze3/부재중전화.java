package bronze3;

import java.util.Scanner;

public class 부재중전화 {
    public static void main(String[] args) {
        //N 노래수 L 노래 길이 D전화벨 빈번 노래 사이 5초
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int D = scanner.nextInt();
        scanner.close();

        String check="";
        for(int i=0; i<N; i++){
            for (int j=0; j<L; j++){
                check += 1;
            }
            if (i!=N-1) {
                check += "00000";
            }
            else {
                for (int j=0; j<D; j++){
                    check += 0;
                }
            }
        }
        for (int i=0; i<check.length(); i+=(D)){
            if (check.substring(i,i+1).equals("0")){
                System.out.println(i);
                break;
            }
        }
    }
}

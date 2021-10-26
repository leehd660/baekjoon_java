package silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S5_11576 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int num = 0;
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        for (int i=0; i<n; i++){
            num += (int)Math.pow(A,n-1-i)*arr[i];
        }
        List<Integer> answer = new ArrayList<>();
        while (true) {
            int ans = num%B;
            if (num/B != 0) {
                answer.add(ans);
            }
            else {
                answer.add(ans);
                break;
            }
            num = num/B;
        }
        String outAns = "";
        for (int i=0; i<answer.size(); i++){
            outAns += String.valueOf(answer.get(answer.size()-1-i)) + " ";
        }
        System.out.println(outAns);
    }
}

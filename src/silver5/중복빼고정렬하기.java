package silver5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 중복빼고정렬하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            int num = scanner.nextInt();
            if (arr.contains(num)){
                continue;
            }
            else {
                arr.add(num);
            }
        }
        Collections.sort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}

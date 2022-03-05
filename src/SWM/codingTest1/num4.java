package SWM.codingTest1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class num4 {
    private static List<Integer> list;
    private static int count;
    private static int[] arr;
    private static int num;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num];
        for (int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }
        list = new ArrayList<>();
        count=0;
        for (int i=0; i<num; i++) {
            list.add(arr[i]);
            DFS(arr[i], i);
            list.remove(list.size()-1);
        }
        System.out.println(count);
    }
    static void DFS(int sum, int index) {
        if (list.size()==3) {
            if (sum>=2000 && sum<=2500) {
                count++;
            }
        }
        else {
            for (int i=index+1; i<num; i++) {
                list.add(arr[i]);
                DFS(sum+arr[i] ,i);
                list.remove(list.size()-1);
            }
        }
    }
}

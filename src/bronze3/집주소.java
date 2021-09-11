package bronze3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 집주소 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sizeList = new ArrayList<>();

        while (true) {
            int homeNum = scanner.nextInt();
            int sizeNum = 2;

            if (homeNum==0){
                break;
            }
            else {
                while (true) {
                    int compareNum = homeNum%10;
                    if (compareNum==0){
                        sizeNum += 4;
                    }
                    else if (compareNum ==1){
                        sizeNum += 2;
                    }
                    else {
                        sizeNum += 3;
                    }

                    homeNum = homeNum/10;
                    if (homeNum==0){
                        break;
                    }
                    else {
                        sizeNum += 1;
                    }
                }
            }
            sizeList.add(sizeNum);
        }
        for (int i : sizeList){
            System.out.println(i);
        }
    }
}

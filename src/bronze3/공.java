package bronze3;

import java.util.*;

public class 공 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer,Integer> cupMap = new HashMap<>();
        //key값은 컵의 번호, value는 해당 컵의 위치
        cupMap.put(1,1);
        cupMap.put(2,2);
        cupMap.put(3,3);

        for (int i=0; i<n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a==b){
                continue;
            }
            //특정한 컵의 위치를 알려줌
            int posit_A = cupMap.get(a);
            int posit_B = cupMap.get(b);
            //컵의 위치를 바꿈
            cupMap.put(a,posit_B);
            cupMap.put(b,posit_A);
        }
        scanner.close();
        int answer = 0;

        for (int key : cupMap.keySet()){
            if (cupMap.get(key).equals(1)){
                answer = key;
            }
        }
        System.out.println(answer);
    }
}

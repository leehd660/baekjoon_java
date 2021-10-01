package silver5;

import java.util.HashMap;
import java.util.Map;

public class 셀프넘버 {
    public static void main(String[] args) {
        Map<Integer,Boolean> answerMap = new HashMap<>();
        //모든 수를 맵에 집어넣음
        for (int i=1; i<10001; i++){
            answerMap.put(i,true);
        }

        for (int i=1; i<10001; i++){
            if (answerMap.get(i)==true){
                System.out.println(i);
                int madeNum = i;
                while (true) {
                    int j = madeNum;
                    while (true) {
                        if (j/10 != 0){
                            madeNum += j%10;
                            j = j/10;
                        }
                        else {
                            madeNum += j;
                            break;
                        }
                    }
                    if (madeNum>10000){
                        break;
                    }
                    else {
                        answerMap.put(madeNum, false);
                    }
                }
            }
            else {
                continue;
            }
        }
    }
}

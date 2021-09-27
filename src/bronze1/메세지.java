package bronze1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 메세지 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countG = 0;
        List<String> outputList = new ArrayList<>();
        while (true){
            int memNum = scanner.nextInt();

            if (memNum==0){
                break;
            }
            else {
                if (outputList.size()!=0){
                    outputList.add("");
                }

                String[][] groupArr = new String[memNum][memNum];
                countG++;
                outputList.add("Group "+countG);
                for (int i = 0; i < memNum; i++) {
                    for (int j=0; j<memNum; j++) {
                        groupArr[i][j] = scanner.next();
                    }
                }
                int notNcount =0;
                for (int i = 0; i < memNum; i++) {
                    for (int j=0; j<memNum; j++) {
                        if (groupArr[i][j].equals("N")){
                            outputList.add(groupArr[(i+memNum-j)%memNum][0] + " was nasty about " +groupArr[i][0]);
                        }
                        else {
                            notNcount++;
                        }
                    }
                }
                if (notNcount==Math.pow(memNum,2)){
                    outputList.add("Nobody was nasty");
                }
            }
        }
        for (String s:outputList){
            System.out.println(s);
        }
    }
}

package silver5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Player[] arr = new Player[num];
        AgeCheck ageCheck = new AgeCheck();
        for (int i=0; i<num; i++){
            String line = bf.readLine();
            String[] arr2 = line.split(" ");
            String age = arr2[0];
            String name = arr2[1];
            arr[i] = new Player(Integer.parseInt(age),name,i);
        }
//        for (int i=0;i<num;i++){
//            for (int j=i;j<num; j++){
//                if (i==j){
//                    continue;
//                }
//                else if (Integer.parseInt(arr[i][0])==Integer.parseInt(arr[j][0])){
//                    if (Integer.parseInt(arr[i][2]) > Integer.parseInt(arr[j][2])){
//                        String age1 = arr[j][0];
//                        String name2 = arr[j][1];
//                        String num1 = arr[j][2];
//                        arr[j][0] = arr[i][0];
//                        arr[j][1] = arr[i][1];
//                        arr[j][2] = arr[i][2];
//                        arr[i][0] = age1;
//                        arr[i][1] = name2;
//                        arr[i][2] = num1;
//                    }
//                    else{
//                        continue;
//                    }
//                }
//                else{
//                    if (Integer.parseInt(arr[i][0]) > Integer.parseInt(arr[j][0])){
//                        String age1 = arr[j][0];
//                        String name2 = arr[j][1];
//                        String num1 = arr[j][2];
//                        arr[j][0] = arr[i][0];
//                        arr[j][1] = arr[i][1];
//                        arr[j][2] = arr[i][2];
//                        arr[i][0] = age1;
//                        arr[i][1] = name2;
//                        arr[i][2] = num1;
//                    }
//                    else{
//                        continue;
//                    }
//                }
//            }
//        }
        Arrays.sort(arr,ageCheck);
        for (Player p : arr){
            bw.write(p.age+" "+p.name+'\n');
        }
        bw.close();
    }
}
class Player {
    int age;
    int num;
    String name;
    Player(int age, String name, int num){
        this.age=age;
        this.name = name;
        this.num = num;
    }
}

class AgeCheck implements Comparator<Player>{
    @Override
    public int compare(Player a, Player b) {
        int answer = -1;
        if (a.age>b.age){
            answer = 1;
        }
        else if (a.age == b.age) {
            if (a.num>b.num) {
                answer = 1;
            }
        }
        return answer;
    }
}
package silver5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class S5_2535  {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        S5_2535_Check s5_2535_check = new S5_2535_Check();
        S5_2535_Player[] table = new S5_2535_Player[num];
        for (int i=0; i<num; i++) {
            String infoStr = bf.readLine();
            String[] infoArr = infoStr.split(" ");
            int country = Integer.parseInt(infoArr[0]);
            int person = Integer.parseInt(infoArr[1]);
            int score = Integer.parseInt(infoArr[2]);
            table[i] = new S5_2535_Player(country, person, score);
        }
        Arrays.sort(table,s5_2535_check);
        int orderAward = 0;
        int printCount = 0;
        Map<Integer, Integer> check = new HashMap<>();
        while (true) {
            S5_2535_Player award = table[orderAward];
            if (check.containsKey(award.country)) {
                if (check.get(award.country)<2){
                    check.put(award.country, check.get(award.country)+1);
                }
                else {
                    orderAward++;
                    continue;
                }
            }
            else {
                check.put(award.country, 1);
            }
            bw.write(String.valueOf(award.country) + " " + String.valueOf(award.person) + "\n");
            printCount++;
            orderAward++;
            if (printCount>=3) {
                break;
            }
        }
        bw.close();
    }
}

class S5_2535_Player {
    int country;
    int person;
    int score;

    S5_2535_Player (int country, int person, int score) {
        this.country = country;
        this.person = person;
        this.score = score;
    }
}

class S5_2535_Check implements Comparator<S5_2535_Player> {

    @Override
    public int compare(S5_2535_Player o1, S5_2535_Player o2) {
        int answer = 0;
        if (o1.score <= o2.score) {
            answer = 1;
        }
        else {
            answer = -1;
        }
        return answer;
    }
}

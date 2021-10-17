package silver5;

import java.io.*;
import java.util.*;

public class 점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        CheckScore checkScore = new CheckScore();
        List<Quiz> arr = new ArrayList<>();
        for (int i=1; i<9; i++){
            String s = bf.readLine();
            int num = Integer.parseInt(s);
            arr.add(new Quiz(i,num));
        }
        Collections.sort(arr, checkScore);
        int[] arr1 = new int[5];
        int total = 0;
        for (int i=0; i<5; i++){
            arr1[i] = arr.get(i).proN;
            total += arr.get(i).score;
        }
        bw.write(String.valueOf(total) + '\n');
        Arrays.sort(arr1);
        for (int i:arr1){
            bw.write(String.valueOf(i) + " ");
        }
        bw.close();
    }
}
class Quiz {
    int proN;
    int score;
    Quiz(int proN, int score){
        this.proN=proN;
        this.score=score;
    }
}
class CheckScore implements Comparator<Quiz>{
    @Override
    public int compare(Quiz o1, Quiz o2) {
        int answer = 0;
        if (o1.score>= o2.score){
            answer = -1;
        }
        else {
            answer = 1;
        }
        return answer;
    }
}
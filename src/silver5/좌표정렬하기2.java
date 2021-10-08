package silver5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Coordinate2[] cArr = new Coordinate2[num];
        YCheck yCheck = new YCheck();

        for (int i=0; i<num; i++){
            String xy = bf.readLine();
            String[] arr = xy.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            cArr[i] = new Coordinate2(x,y);
        }
        Arrays.sort(cArr,yCheck);
        for (Coordinate2 c : cArr){
            bw.write(String.valueOf(c.x) + " " + String.valueOf(c.y)+'\n');
        }
        bw.close();
    }
}

class Coordinate2 {
    int x;
    int y;
    Coordinate2(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class YCheck implements Comparator<Coordinate2> {
    @Override
    public int compare(Coordinate2 a, Coordinate2 b) {
        int answer = -1;
        if (a.y>b.y){
            answer = 1;
        }
        else if (a.y==b.y){
            if (a.x>b.x){
                answer = 1;
            }
        }
        return answer;
    }
}
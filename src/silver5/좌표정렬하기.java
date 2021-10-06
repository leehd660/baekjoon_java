package silver5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);

        CompareCheck compareCheck = new CompareCheck();
        Coordinate[] c = new Coordinate[num];


        for (int i=0; i<num; i++){
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            int x = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);
            Coordinate coordinate = new Coordinate(x,y);
            c[i] = coordinate;
        }

        Arrays.sort(c,compareCheck);
        for (Coordinate a : c){
            bw.write(a.x + " " + a.y + '\n');
        }
        bw.close();
    }
}
class Coordinate {
    int x;
    int y;

    Coordinate(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class CompareCheck implements Comparator<Coordinate>{
    @Override
    public int compare(Coordinate a, Coordinate b) {
        int answer = 1;
        if (a.x>b.x){
            //1이 순서를 바꾸겠다는 뜻.
            answer = 1;
        }
        else if (a.x<b.x){
            answer = -1;
        }
        else{
            if (a.y>b.y){
                answer = 1;
            }
            else {
                answer = -1;
            }
        }
        return answer;
    }
}
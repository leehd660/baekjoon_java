package silver4;

import java.io.*;

public class S4_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence = bf.readLine();
        String[] arr = sentence.split(" ");
        String A = arr[0];
        String B = arr[1];
        int aLen = A.length();
        int bLen = B.length();
        int answer = aLen;
        for (int i=0; i<bLen-aLen+1; i++){
            String str = B.substring(i,i+aLen);
            int num = check(A, str);
            if (answer > num){
                answer = num;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static int check (String s1, String s2) {
        int answer = 0;
        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");
        for (int i=0; i<s1.length(); i++) {
            if (arr1[i].equals(arr2[i])) {
                continue;
            }
            else{
                answer ++;
            }
        }
        return answer;
    }
}

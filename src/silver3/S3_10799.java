package silver3;

import java.io.*;

public class S3_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] strArr = str.split("");
//        List<Integer> list = new ArrayList<>();
        int stickNum = 0;
        int answer = 0;
        for (int i=0; i<strArr.length; i++) {
            if (i!=strArr.length-1 && strArr[i].equals("(") && strArr[i+1].equals(")")) {
//                for (int j=0; j<list.size(); j++) {
//                    list.set(j,list.get(j)+1);
//                }
                answer += stickNum;
                i++;
            }
            else if (strArr[i].equals("(")) {
//                list.add(0);
                stickNum++;
            }
            else if (strArr[i].equals(")")) {
//                answer += list.get(list.size()-1)+1;
//                list.remove(list.size()-1);
                stickNum--;
                answer ++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

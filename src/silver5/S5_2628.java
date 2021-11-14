package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sizeStr = bf.readLine();
        String[] sizeArr = sizeStr.split(" ");
        int M = Integer.parseInt(sizeArr[0]);
        int N = Integer.parseInt(sizeArr[1]);
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        List<Integer> mList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        mList.add(0);
        nList.add(0);
        mList.add(M);
        nList.add(N);
        for (int i=0; i<num; i++) {
            String cutStr = bf.readLine();
            String[] cutArr = cutStr.split(" ");
            if (cutArr[0].equals("1")){
                mList.add(Integer.parseInt(cutArr[1]));
            }
            else {
                nList.add(Integer.parseInt(cutArr[1]));
            }
        }
        Collections.sort(mList);
        Collections.sort(nList);
        int maxM = 0;
        int maxN = 0;
        for (int i=1; i<mList.size(); i++) {
            maxM = Math.max(mList.get(i)-mList.get(i-1),maxM);
        }
        for (int i=1; i<nList.size(); i++) {
            maxN = Math.max(nList.get(i)-nList.get(i-1),maxN);
        }
        int answer = maxM*maxN;
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

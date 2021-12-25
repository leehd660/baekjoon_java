package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        //하나의 리스트를 만들어 놓고 케이스별로 뽑아만 내는게 더 좋긴 한데 우선 케이스마다 돌려보기
        for (int i=0; i<T; i++) {
            List<Long> dp = new ArrayList<>();
            dp.add(1L);
            dp.add(1L);
            dp.add(1L);
            dp.add(2L);
            dp.add(2L);
            int caseNum = Integer.parseInt(bf.readLine());
            if (caseNum <= 5) {
                bw.write(String.valueOf(dp.get(caseNum-1))+"\n");
            }
            else {
                for (int j=5; j<caseNum; j++) {
                    long checkNum = dp.get(j-1) + dp.get(j-5);
                    dp.add(checkNum);
                }
                bw.write(String.valueOf(dp.get(caseNum-1)+"\n"));
            }
        }
        bw.close();
    }
}

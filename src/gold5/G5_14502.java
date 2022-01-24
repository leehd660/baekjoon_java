package gold5;

import java.io.*;
import java.util.*;

public class G5_14502 {
    private static int N;
    private static int M;
    private static int[][] lab;
    private static List<int[]> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        StringTokenizer NMtoken = new StringTokenizer(NMstr);
        N = Integer.parseInt(NMtoken.nextToken());
        M = Integer.parseInt(NMtoken.nextToken());
        lab = new int[N][M];
        List<int[]> list = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String labMap = bf.readLine();
            String[] labMapArr = labMap.split(" ");
            for (int j=0; j<M; j++) {
                lab[i][j] = Integer.parseInt(labMapArr[j]);
                if (labMapArr[j].equals("2")) {
                    int[] arr = {i,j};
                    virus.add(arr);
                }
                else if (labMapArr[j].equals("0")) {
                    int[] arr = {i,j};
                    list.add(arr);
                }
            }
        }
        int answer = 0;
        for (int index1=0; index1<list.size()-2; index1++) {
            lab[list.get(index1)[0]][list.get(index1)[1]] = 1;
            for (int index2=index1+1; index2<list.size()-1; index2++) {
                lab[list.get(index2)[0]][list.get(index2)[1]] = 1;
                for (int index3=index2+1; index3<list.size(); index3++) {
                    lab[list.get(index3)[0]][list.get(index3)[1]] = 1;
                    answer = Math.max(checkVirus(),answer);
                    lab[list.get(index3)[0]][list.get(index3)[1]] = 0;
                }
                lab[list.get(index2)[0]][list.get(index2)[1]] = 0;
            }
            lab[list.get(index1)[0]][list.get(index1)[1]] = 0;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static int checkVirus() {
        int[][] copyLab = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                copyLab[i][j] = lab[i][j];
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i=0; i<virus.size(); i++) {
            deque.add(virus.get(i));
        }
        while (!deque.isEmpty()) {
            int[] arr = deque.pollFirst();
            int x = arr[0];
            int y = arr[1];
            try {
                if (copyLab[x-1][y] == 0) {
                    int[] newArr = {x-1,y};
                    deque.add(newArr);
                    copyLab[x-1][y] = 2;
                }
            }catch (IndexOutOfBoundsException e) {}
            try {
                if (copyLab[x][y-1] == 0) {
                    int[] newArr = {x,y-1};
                    deque.add(newArr);
                    copyLab[x][y-1] = 2;
                }
            }catch (IndexOutOfBoundsException e) {}
            try {
                if (copyLab[x+1][y] == 0) {
                    int[] newArr = {x+1,y};
                    deque.add(newArr);
                    copyLab[x+1][y] = 2;
                }
            }catch (IndexOutOfBoundsException e) {}
            try {
                if (copyLab[x][y+1] == 0) {
                    int[] newArr = {x,y+1};
                    deque.add(newArr);
                    copyLab[x][y+1] = 2;
                }
            }catch (IndexOutOfBoundsException e) {}
        }
        int zeroNum = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (copyLab[i][j]==0) {
                    zeroNum++;
                }
            }
        }
        return zeroNum;
    }
}

package silver4;

import java.io.*;

public class S4_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String switchStr = bf.readLine();
        int switchNum = Integer.parseInt(switchStr);
        int[] table = new int[switchNum];
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        for (int i=0; i<switchNum; i++) {
            table[i] = Integer.parseInt(strArr[i]);
        }
        String testStr = bf.readLine();
        int testNum = Integer.parseInt(testStr);
        for (int i=0; i<testNum; i++) {
            String test = bf.readLine();
            String[] testArr = test.split(" ");
            int sex = Integer.parseInt(testArr[0]);
            int num = Integer.parseInt(testArr[1]);
            if (sex == 1) {
                table = Man(table, num);
            }
            else {
                table = Woman(table, num);
            }
        }
        for (int i=0; i<table.length; i++) {
            if (i%20 ==0 && i!=0) {
                bw.write("\n");
                bw.write(String.valueOf(table[i]+" "));
            }
            else {
                bw.write(String.valueOf(table[i]+" "));
            }
        }
        bw.close();
    }

    static int[] Man(int[] table, int n) {
        int num = n-1;
        while (table.length > num) {
            if (table[num] == 0) {
                table[num] = 1;
            }
            else {
                table[num] = 0;
            }
            num = num+n;
        }
        return table;
    }
    static int[] Woman (int[] table, int n) {
        int num = n-1;
        if (table[num] == 0) {
            table[num] = 1;
        }
        else {
            table[num] = 0;
        }
        int downNum = num-1;
        int upNum = num+1;
        while (downNum>=0 && upNum<table.length && table[downNum] == table[upNum]) {
            if (table[downNum] == 0) {
                table[downNum] = 1;
                table[upNum] = 1;
            }
            else {
                table[downNum] = 0;
                table[upNum] = 0;
            }
            downNum--;
            upNum++;
            if (downNum>=0 && upNum<table.length) {
                continue;
            }
            else {
                break;
            }
        }
        return table;
    }
}

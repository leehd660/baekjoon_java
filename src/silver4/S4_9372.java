package silver4;

import java.io.*;

public class S4_9372 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String strT = bf.readLine();
        int T = Integer.parseInt(strT);
        for (int i=0; i<T; i++){
            String str = bf.readLine();
            String[] arr = str.split(" ");
            int country = Integer.parseInt(arr[0]);
            int airplane = Integer.parseInt(arr[1]);
            for (int j=0; j<airplane; j++) {
                String str1 = bf.readLine();
            }
            bw.write(String.valueOf(country-1));
            bw.write("\n");
        }
        bw.close();
    }
}

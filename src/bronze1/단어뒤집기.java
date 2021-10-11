package bronze1;

import java.io.*;

public class 단어뒤집기 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String numStr = bf.readLine();
//        int num = Integer.parseInt(numStr);
//        for (int i=0; i<num; i++){
//            String answer = "";
//            String str = bf.readLine();
//            String[] arr = str.split(" ");
//            for (String s: arr) {
//                String[] word = s.split("");
//                for (int j=word.length-1; j>=0; j--) {
//                    answer += word[j];
//                }
//                answer += " ";
//            }
//            bw.write(answer + '\n');
//        }
//        bw.close();

//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        for (int i=0; i<num; i++){
//            String answer = "";
//            while (true) {
//                String word = scanner.next();
//                if (word.equals('\n')) {
//                    System.out.println();
//                    break;
//                }
//                else {
//                    String[] wordArr = word.split("");
//                    for (int j = word.length() - 1; j >= 0; j--) {
//                        answer += wordArr[j];
//                    }
//                }
//                System.out.print(" ");
//            }
//        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++){
//            String answer = "";
            String line = bf.readLine();
//            String[] arr = line.split("");
            int start = 0;
            for (int j=0; j<line.length(); j++){
                if (line.substring(j,j+1).equals(" ")){
                    for (int k=j-1; k>=start; k--){
//                        answer += arr[k];
                        bw.write(line.substring(k,k+1));
                    }
//                    answer += " ";
                    bw.write(" ");
                    start = j+1;
                }
                else if (j==line.length()-1) {
                    for (int k=j; k>=start; k--){
//                        answer += arr[k];
                        bw.write(line.substring(k,k+1));
                    }
                }
            }
//            bw.write(answer + '\n');
            bw.write('\n');
        }
        bw.close();
    }
}

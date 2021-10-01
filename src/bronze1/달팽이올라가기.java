package bronze1;

import java.io.*;

public class 달팽이올라가기 {
//    public static void main(String[] args) throws IOException {
////        Scanner scanner = new Scanner(System.in);
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String str = bf.readLine();
//        String[] arr = (str.split(" "));
//        long A= Long.parseLong(arr[0]);
//        long B= Long.parseLong(arr[1]);
//        long V= Long.parseLong(arr[2]);
////        long B=scanner.nextInt();
////        long V=scanner.nextInt();
////        scanner.close();
//        long count=0;
//        long gogo = 0;
//        while (true){
//            count++;
//            gogo += A;
//            if (gogo>=V){
//                break;
//            }
//            else {
//                gogo -= B;
//            }
//        }
//        bw.write(String.valueOf(count));
//        bw.close();
////        System.out.println(count);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] arr = (str.split(" "));
        long A= Long.parseLong(arr[0]);
        long B= Long.parseLong(arr[1]);
        long V= Long.parseLong(arr[2]);
        if (V-A <= 0){
            System.out.println(1);
        }
        else {
            if ((V-A)%(A-B)==0){
                bw.write(String.valueOf(((V-A)/(A-B))+1));
                bw.close();
            }
            else {
                bw.write(String.valueOf(((V-A)/(A-B))+2));
                bw.close();
            }
        }
    }
}

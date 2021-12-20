package silver4;

import java.io.*;
import java.util.Arrays;

public class S4_2776 {
//    public static void main(String[] args) throws IOException {
////        Scanner scanner = new Scanner(System.in);
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
////        int T = scanner.nextInt();
//        String Tstr = bf.readLine();
//        int T = Integer.parseInt(Tstr);
//        for (int i=0; i<T; i++) {
//            String arr1Str = bf.readLine();
////            int arr1Num = Integer.parseInt(arr1Str);
//            List<Integer> arr1 = new ArrayList<>();
//            String arr1NumStr = bf.readLine();
//            String[] arr1NumArr = arr1NumStr.split(" ");
//            for (String s : arr1NumArr) {
//                int num = Integer.parseInt(s);
//                arr1.add(num);
//            }
//            Collections.sort(arr1);
//            String arr2Str = bf.readLine();
//            int arr2Num = Integer.parseInt(arr2Str);
//            String arr2NumStr = bf.readLine();
//            String[] arr2NumArr = arr2NumStr.split(" ");
//            for (String s : arr2NumArr) {
//                int num = Integer.parseInt(s);
//                if (arr1.contains(num)) {
//                    bw.write("1\n");
//                }
//                else {
//                    bw.write("0\n");
//                }
//            }
//        }
//        bw.close();
//    }
//
//    static boolean containTest(int[] arr, int findNum) {
//        int num = arr.length/2;
////        if (arr.length)
//        if(findNum == arr[num]) {
//            return true;
//        }
//        else if (findNum < arr[num]){
//            return containTest(arr, num/2);
//        }
//        else {
//            return containTest(arr, (int)(num+(num/2)));
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String Tstr = bf.readLine();
        int Tnum = Integer.parseInt(Tstr);
        for (int i=0; i<Tnum; i++) {
            int note1Len = Integer.parseInt(bf.readLine());
//            String note1 = bf.readLine();
            String[] note1Arr = bf.readLine().split(" ");
            int[] note1 = new int[note1Len];
            for (int j=0; j<note1Len; j++) {
                note1[j] = Integer.parseInt(note1Arr[j]);
            }
//            int[] note1 = Arrays.stream(bf.readLine().split(" ",note1Len))
//                    .mapToInt(Integer::parseInt).toArray();
            Arrays.sort(note1);
//            for (int num : note1) {
//                System.out.println(num);
//            }
            int note2Len = Integer.parseInt(bf.readLine());
//            String note2 = bf.readLine();
//            String[] note2Arr = note2.split(" ");
//            int note2Len = Integer.parseInt(bf.readLine());
//            int[] note2 = Arrays.stream(bf.readLine().split(" ", note2Len))
//                    .mapToInt(Integer::parseInt).toArray();
            String[] note2Arr = bf.readLine().split(" ");
            int[] note2 = new int[note2Len];
            for (int j=0; j<note2Len; j++) {
                note2[j] = Integer.parseInt(note2Arr[j]);
            }

//            Arrays.stream(solution(note1, note2)).forEach(System.out::println);
            int[] answer = solution(note1, note2);
            for (int num : answer) {
                bw.write(String.valueOf(num)+"\n");
            }
        }
        bw.close();
    }

    static int[] solution (int[] note1, int[] note2) {
        int[] answer = new int[note2.length];

        //2진 탐색을 위한 low와 high, mid 지정
        int low = 0;
        int high = note1.length -1;
        int mid;

        for (int i=0; i<note2.length; i++) {
            while (low <= high) {
                //
                mid = (low+high)/2;

                if (note2[i] == note1[mid]) {
                    answer[i] = 1;
                }

                if (note2[i] < note1[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            //초기화를 해주는거
            low = 0;
            high = note1.length -1;
        }
        return answer;
    }

}

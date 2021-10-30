package silver5;

import java.io.*;

public class S5_17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        Answer(0,num);
    }

    static void Answer(int n, int num) throws IOException {
        if (n<num) {
            for (int i=0; i<n; i++){
                System.out.print("____");
            }
            System.out.println("\"재귀함수가 뭔가요?\"");
//            bw.write("\n");
            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write();
            }
            System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
//            bw.write("\n");
            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write("____");
            }
            System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
//            bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write("____");
            }
            System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
//            bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

            Answer(n+1,num);

            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write("____");
            }
            System.out.println("라고 답변하였지.");
//            bw.write("라고 답변하였지.\n");
        }
        else {
            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write("____");
            }
            System.out.println("\"재귀함수가 뭔가요?\"");
//            bw.write("\"재귀함수가 뭔가요?\"\n");
            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write("____");
            }
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
//            bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            for (int i=0; i<n; i++){
                System.out.print("____");
//                bw.write("____");
            }
            System.out.println("라고 답변하였지.");
//            bw.write("라고 답변하였지.\n");
        }
//        bw.close();
    }
}

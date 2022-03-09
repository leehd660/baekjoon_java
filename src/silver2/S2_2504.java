package silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S2_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        Stack<String> stack = new Stack<>();
        boolean check = true;
        for (String s : str.split("")) {
            if (stack.isEmpty()) {
                stack.add(s);
            }
            else {
                if (s.equals("(") || s.equals("[")) {
                    stack.add(s);
                }
                else {
                    if (stack.peek().equals("[")) {
                        if (s.equals("]")) {
                            stack.pop();
                        }
                        else {
                            check = false;
                            break;
                        }
                    }
                    else {
                        if (s.equals(")")) {
                            stack.pop();
                        }
                        else {
                            check = false;
                            break;
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            check = true;
        }
        else {
            check = false;
        }

        List<String> list = new ArrayList<>();
        if (check) {
            //list에 넣으면서 소괄호를 모두 숫자로 바꿈
            for (String s : str.split("")) {
                if (s.equals("(") || s.equals("[")) {
                    list.add(s);
                }
                else {
                    if (list.get(list.size() - 1).equals("[")) {
                        if (s.equals("]")) {
                            list.remove(list.size() - 1);
                            list.add(String.valueOf(3));
                        }
                    }
                    else if (list.get(list.size() - 1).equals("(")) {
                        if (s.equals(")")) {
                            list.remove(list.size() - 1);
                            list.add(String.valueOf(2));
                        }
                    }
                    else {
                        list.add(s);
                    }
                }
            }

            while (list.size()!=1) {
                //숫자, 숫자인거 더해주기
                for (int i=0; i<list.size(); i++) {
                    String s = list.get(i);
                    if (!s.equals("(") && !s.equals(")") && !s.equals("[") && !s.equals("]")) {
                        if (i+1<list.size()) {
                            String s1 = list.get(i+1);
                            if (!s1.equals("(") && !s1.equals(")") && !s1.equals("[") && !s1.equals("]")) {
                                list.set(i,String.valueOf(Integer.parseInt(list.get(i))+Integer.parseInt(list.get(i+1))));
                                list.remove(i+1);
//                                i-=1;
                            }
                        }
                    }
                }
                //괄호 숫자 괄호인걸 찾아서 연산해주기
                for (int i=0; i<list.size(); i++) {
                    String s = list.get(i);
                    if (!s.equals("(") && !s.equals(")") && !s.equals("[") && !s.equals("]")) {
                        if (i-1>=0 && i+1<list.size()) {
                            if (list.get(i-1).equals("(") && list.get(i+1).equals(")")) {
                                list.set(i,String.valueOf(Integer.parseInt(list.get(i))*2));
                                list.remove(i+1);
                                list.remove(i-1);
//                                i-=1;
                            }
                            else if (list.get(i-1).equals("[") && list.get(i+1).equals("]")) {
                                list.set(i,String.valueOf(Integer.parseInt(list.get(i))*3));
                                list.remove(i+1);
                                list.remove(i-1);
//                                i-=1;
                            }
                        }
                    }
                }
            }
            bw.write(list.get(0));
        }
        else {
            bw.write(String.valueOf(0));
        }
        bw.close();
    }
}

package bronze3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 팔진수이진수 {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            String n = scanner.nextLine();

            int tenNum = Integer.parseInt(n,8);
            String answer = Integer.toString(tenNum,2);
            System.out.println(answer);
        }
        catch (InputMismatchException ime) {
            System.exit(0);
        }
        catch (NumberFormatException nfe){
            System.exit(0);
        }
    }
}

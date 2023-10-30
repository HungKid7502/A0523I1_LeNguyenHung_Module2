package ss2_Loop_in_Java.exercise;
import java.util.Scanner;

public class First20PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 20;
        int count = 0;
        int number = 2;
        while (count < n) {
            boolean flag = true;
            if (number >= 2) {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(number);
                    count++;
                }
            }
            number++;
        }
    }
}

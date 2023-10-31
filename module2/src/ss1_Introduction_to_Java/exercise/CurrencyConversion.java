package ss1_Introduction_to_Java.exercise;
import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USD amount: ");
        double USD = sc.nextDouble();
        System.out.print("Enter currency exchange rate: ");
        double rate = sc.nextDouble();
        double VND = USD * rate;
        System.out.println("The VND amount is: " + VND + "VND");
        sc.close();
    }
}

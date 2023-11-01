package ss3_Array_And_Method_in_Java.exercise;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Bước 1: Khai báo chuỗi và gán giá trị
        System.out.println("Enter the string: ");
        String str = sc.nextLine();

        // Bước 2: Khai báo một biến ký tự và gán hoặc nhập giá trị
        System.out.print("Enter the character to count: ");
        char countChar = sc.next().charAt(0);

        // Bước 3: Khai báo biến count và gán giá trị 0
        int count = 0;

        // Bước 4: Dùng vòng lặp duyệt mảng để đếm số lần ký tự xuất hiện trong chuỗi
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == countChar) {
                count++;
            }
        }
        if (count > 0)
            System.out.println("The character " + countChar + " appears " + count + " times in the string");
        else
            System.out.println("The character does not appear in the array");
    }
}

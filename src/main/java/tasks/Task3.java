package tasks;

import lib.Polyndrome;

import java.util.Scanner;

public class Task3 implements TaskInterface {
    @Override
    public void execute() {
        System.out.print("Введите строку для проверки: > ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();

        Polyndrome polyndrome = new Polyndrome(str);

        System.out.println("\nРезультат:\n");
        if (polyndrome.isPolyndrome()) {
            System.out.println("Строка является полиндромом");
        } else {
            System.out.println("Строка не является полиндромом");
        }
    }
}

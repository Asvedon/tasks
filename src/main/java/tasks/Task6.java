package tasks;

import lib.Encoder;

import java.util.Scanner;

public class Task6 implements TaskInterface {
    @Override
    public void execute() {
        System.out.print("Введите строку для сжатия: > ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Encoder encoder = new Encoder();

        System.out.println("\nРезультат:\n");
        System.out.println(String.format("Исходная строка %s", str));
        System.out.println(String.format("Сжатая строка %s", encoder.encode(str)));
    }
}

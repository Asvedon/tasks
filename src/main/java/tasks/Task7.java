package tasks;

import lib.Encoder;

import java.util.Scanner;

public class Task7 implements TaskInterface {
    @Override
    public void execute() {
        System.out.print("Введите строку для декодирования: > ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Encoder encoder = new Encoder();

        System.out.println("\nРезультат:\n");
        System.out.println(String.format("Исходная строка %s", str));
        System.out.println(String.format("Декодированная строка %s", encoder.decode(str)));
    }
}

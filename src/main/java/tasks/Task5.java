package tasks;

import lib.SimpleStringSercher;

import java.util.Scanner;

public class Task5 implements TaskInterface {
    @Override
    public void execute() {
        System.out.print("Введите исходную строку: > ");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print("Введите строку для поиска: > ");
        String searcStr = sc.nextLine();

        SimpleStringSercher stringSercher = new SimpleStringSercher(str);

        System.out.println("\nРезультат:\n");
        if (stringSercher.contain(searcStr)) {
            System.out.println("Искомая строка присутствует");
        } else {
            System.out.println("Искомая строка отсутствует");
        }
    }
}

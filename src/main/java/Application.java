import tasks.*;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static Random random = new Random();

    public static void main(String[] args) {
        printMenu();
        System.out.print("\nВведите номер задачи для запуска: > ");
        Scanner sc = new Scanner(System.in);
        int taskNumber = sc.nextInt();

        while (taskNumber > 0) {
            switch (taskNumber) {
                case 1:
                    System.out.println("\nTask-1. Вывод n-й по величине элемент набора чисел\n");
                    Task1 task1 = new Task1();
                    task1.execute();
                    break;
                case 2:
                    System.out.println("\nTask-2. Вывод простых множителей числа\n");
                    Task2 task2 = new Task2();
                    task2.execute();
                    break;
                case 3:
                    System.out.println("\nTask-3. Проверить является ли строка полиндромом\n");
                    Task3 task3 = new Task3();
                    task3.execute();
                    break;
                case 4:
                    System.out.println("\nTask-4. Вернуть список разменов на 3, 5, 7 копеек\n");
                    Task4 task4 = new Task4();
                    task4.execute();
                    break;
                case 5:
                    System.out.println("\nTask-5. Найти подстроку в строке\n");
                    Task5 task5 = new Task5();
                    task5.execute();
                    break;
                case 6:
                    System.out.println("\nTask-6. Выполнить Run-length кодирование строки\n");
                    Task6 task6 = new Task6();
                    task6.execute();
                    break;
                case 7:
                    System.out.println("\nTask-7. Выполнить Run-length декодирование строки\n");
                    Task7 task7 = new Task7();
                    task7.execute();
                    break;
                case 8:
                    System.out.println("\nTask-8. Прочитать данные из файла и создать файл с результатом\n");
                    Task8 task8 = new Task8();
                    task8.execute();
                    break;
            }
            printMenu();
            System.out.print("\nВведите номер задачи для запуска: > ");
            taskNumber = sc.nextInt();
        }

        System.exit(0);
    }

    private static void printMenu() {
        System.out.println("\nДля запуска задачи введите ее номер и нажмите Enter");
        System.out.println("\n0 - Выйти из программы");
        System.out.println("1 - Task-1. Вывод n-й по величине элемент набора чисел");
        System.out.println("2 - Task-2. Вывод простых множителей числа");
        System.out.println("3 - Task-3. Проверить является ли строка полиндромом");
        System.out.println("4 - Task-4. Вернуть список разменов на 3, 5, 7 копеек");
        System.out.println("5 - Task-5. Найти подстроку в строке");
        System.out.println("6 - Task-6. Выполнить Run-length кодирование строки");
        System.out.println("7 - Task-7. Выполнить Run-length декодирование строки");
        System.out.println("8 - Task-8. Прочитать данные из файла и создать файл с результатом");
    }
}

package tasks;

import lib.SimpleArrayList;
import lib.SimpleSort;

import java.util.Random;
import java.util.Scanner;

public class Task1 implements TaskInterface {
    private Random random;

    public Task1() {
        this.random = new Random();
    }

    @Override
    public void execute() {
        System.out.print("Введите желаемый размер массива: > ");
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();

        System.out.print("Введите требуемый номер максимума: > ");
        int maxNumber = sc.nextInt();

        if (arraySize > 0 && maxNumber > 0 && maxNumber <= arraySize) {
            SimpleArrayList<Integer> array = new SimpleArrayList<>();
            int range = arraySize > 100 ? arraySize * 2 : 100;
            for (int i = 0; i < arraySize; i++) {
                array.add(random.nextInt(range));
            }

            SimpleSort<Integer> sorter = new SimpleSort<>(array);

            StringBuilder arrayString = new StringBuilder();
            arrayString.append("Исходный массив: ");
            for (int i = 0; i < array.size(); i++) {
                arrayString.append(array.get(i));
                arrayString.append(", ");
            }

            System.out.println("\nРезультат:\n");
            System.out.println(arrayString);
            System.out.println(String.format("%n%d по величине элемент в созданном массиве %d", maxNumber, sorter.getMaxByIndex(maxNumber)));
        } else {
            System.out.println("Введены не корректные данные.");
            System.out.println("Размер массива должен быть больше 0, а номер максимума не больше размера массива.");
        }
    }
}

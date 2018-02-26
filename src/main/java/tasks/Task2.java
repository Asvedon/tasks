package tasks;

import lib.NumberMultipliers;

import java.util.Scanner;

public class Task2 implements TaskInterface {
    @Override
    public void execute() {
        System.out.print("Введите число: > ");
        Scanner sc = new Scanner(System.in);
        int testNumber = sc.nextInt();

        NumberMultipliers numberMultipliers = new NumberMultipliers(testNumber);

        StringBuilder multipliersString = new StringBuilder();
        int[] multipliers = numberMultipliers.getMultipliers();
        for (int i = 0; i < multipliers.length; i++) {
            multipliersString.append(multipliers[i]);
            multipliersString.append(", ");
            if (i > 0 && i % 20 == 0) {
                multipliersString.append("\n");
            }
        }

        System.out.println("\nРезультат:\n");
        System.out.println(String.format("%nПростые множители числа %d:", testNumber));
        if (multipliers.length == 0) {
            System.out.println("Число делится только на 1 и на само себя.");
        } else {
            System.out.println(multipliersString);
        }
    }
}

package tasks;

import lib.CombinationsSearch;

import java.util.Scanner;

public class Task4 implements TaskInterface {
    @Override
    public void execute() {
        System.out.print("Введите число: > ");
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        CombinationsSearch cs = new CombinationsSearch(new int[]{3, 5, 7});
        System.out.println("\nРезультат:\n");
        cs.getVariants(input);
    }
}

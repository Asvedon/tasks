package tasks;

import filetask.Executor;
import lib.SimpleFileHelper;

import java.io.File;
import java.io.IOException;

public class Task8 implements TaskInterface {
    @Override
    public void execute() {
        SimpleFileHelper input = new SimpleFileHelper(new File("input.txt"));
        SimpleFileHelper output = new SimpleFileHelper(new File("output.txt"));

        try {
            String[] data = input.read();
            Executor[] thread = new Executor[data.length];
            for (int i = 0; i < data.length; i++) {
                thread[i] = new Executor("Executor_" + i, i + 1, data[i], output);
                thread[i].start();
            }

            for (int i = 0; i < thread.length; i++) {
                try {
                    thread[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\nРезультат:\n");
            System.out.println("Проверьте файл output.txt в текущей директории");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

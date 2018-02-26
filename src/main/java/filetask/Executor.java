package filetask;

import lib.SimpleArrayList;
import lib.SimpleFileHelper;

import java.io.IOException;

public class Executor extends Thread {
    private String input;
    private String[] data;
    private SimpleArrayList<Integer> arguments;
    private SimpleFileHelper output;
    private int rowNumber;

    public Executor(String name, int row, String input, SimpleFileHelper output) {
        super(name);
        this.input = input;
        this.arguments = new SimpleArrayList<>();
        this.output = output;
        this.rowNumber = row;
    }

    public void run() {
        setData();

        Functions function = Functions.valueOf(data[0].toUpperCase());

        if (function != null) {
            Object result = function.execute(arguments.toArray());
            String[] fileStrings = new String[1];
            fileStrings[0] = "" + rowNumber + " " + result;
            try {
                output.append(fileStrings);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setData() {
        data = input.split(" ");

        for (int i = 1; i < data.length; i++) {
            arguments.add(Integer.valueOf(data[i]));
        }
    }
}

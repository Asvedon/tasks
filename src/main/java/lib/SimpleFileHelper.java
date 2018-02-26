package lib;

import java.io.*;

public class SimpleFileHelper {
    private File file;

    public SimpleFileHelper(File file) {
        if (file.exists()) {
            this.file = file;
        } else {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    this.file = file;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String[] strings) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < strings.length; i++) {
                if (i == 0) {
                    writer.write(strings[i]);
                } else {
                    writer.append(strings[i]);
                }
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw e;
        }
    }

    public void append(String[] strings) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String string : strings) {
                writer.append(string);
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw e;
        }
    }

    public String[] read() throws IOException {
        String[] results = new String[0];
        SimpleArrayList<String> result = new SimpleArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                result.add(fileLine);
            }
            results = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                results[i] = result.get(i);
            }
        } catch (IOException e) {
            throw e;
        }
        return results;
    }
}

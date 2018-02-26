package lib;

public class SimpleStringSercher {
    private String input;

    public SimpleStringSercher(String input) {
        this.input = input;
    }

    public boolean contain(String search) {
        boolean result = false;
        int position;

        for (int i = 0; i < input.length() - search.length(); i++) {
            if (input.charAt(i) == search.charAt(0)) {
                position = i;
                int subIndex = 0;
                while (subIndex < search.length()) {
                    result = true;
                    if (input.charAt(position + subIndex) != search.charAt(subIndex)) {
                        result = false;
                        break;
                    }
                    subIndex++;
                }
            }
            if (result) {
                break;
            }
        }

        return result;
    }
}

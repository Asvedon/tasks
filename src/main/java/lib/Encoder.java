package lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encoder {
    private Pattern strPattern;
    private Matcher matcher;

    public Encoder() {
        this.strPattern = Pattern.compile("[0-9]+|[a-zA-Z]");
    }

    public String encode(String input) {
        StringBuilder result = new StringBuilder();
        int charCount = 1;
        char current = input.charAt(0);
        int i = 1;

        while (i < input.length()) {
            if (i == input.length() - 1 || input.charAt(i) != current) {
                if (i == input.length() - 1) {
                    charCount++;
                }
                result.append(charCount);
                result.append(current);
                charCount = 1;
                current = input.charAt(i);
            } else {
                charCount++;
            }
            i++;
        }

        return result.toString();
    }

    public String decode(String input) {
        StringBuilder result = new StringBuilder();

        matcher = strPattern.matcher(input);
        while (matcher.find()) {
            int charCount = Integer.parseInt(matcher.group());
            matcher.find();
            while (charCount-- != 0) {
                result.append(matcher.group());
            }
        }

        return result.toString();
    }
}

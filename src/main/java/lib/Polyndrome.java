package lib;

public class Polyndrome {
    private String input;

    public Polyndrome(String input) {
        this.input = input;
    }

    public boolean isPolyndrome() {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

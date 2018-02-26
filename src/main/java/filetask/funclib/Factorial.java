package filetask.funclib;

import filetask.FunctionInterface;

public class Factorial implements FunctionInterface {
    @Override
    public Object calculate(Object... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                return getValue((Integer) args[i]);
            }
        }
        return 0;
    }

    private long getValue(int n) {
        if (n == 0) {
            return 1;
        }

        long result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}

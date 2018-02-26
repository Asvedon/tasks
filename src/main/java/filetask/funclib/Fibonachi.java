package filetask.funclib;

import filetask.FunctionInterface;

public class Fibonachi implements FunctionInterface {
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
        long a = 1;
        long b = 1;

        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }

        long result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}

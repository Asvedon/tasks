package filetask.funclib;

import filetask.FunctionInterface;

public class Ackermann implements FunctionInterface {
    private AckermanTable aNumbers;

    @Override
    public Object calculate(Object... args) {
        int m, n;
        m = n = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer && m == -1) {
                m = (Integer) args[i];
            } else if (args[i] instanceof Integer && n == -1) {
                n = (Integer) args[i];
            }
            if (m >= 0 && n >= 0) {
                break;
            }
        }

        if (m >= 0 && n >= 0) {
            aNumbers = new AckermanTable(m, n);
            return getValue(m, n);
        }

        return null;
    }

    private int getValue(int m, int n) {
        if (m == 0) {
            aNumbers.setValue(m, n, n + 1);
            return n + 1;
        }
        if (m > 0 && n == 0) {
            if (aNumbers.getValue(m, n) != 0) {
                return aNumbers.getValue(m, n);
            }
            int value = getValue(m - 1, 1);
            aNumbers.setValue(m, n, value);
            return value;
        }
        if (m > 0 && n > 0) {
            if (aNumbers.getValue(m, n) != 0) {
                return aNumbers.getValue(m, n);
            }
            int value = getValue(m - 1, getValue(m, n - 1));
            aNumbers.setValue(m, n, value);
            return value;
        }
        return 0;
    }
}

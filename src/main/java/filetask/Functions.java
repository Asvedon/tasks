package filetask;

import filetask.funclib.Ackermann;
import filetask.funclib.Factorial;
import filetask.funclib.Fibonachi;

public enum Functions {
    ACK {
        public Object execute(Object... args) {
            Ackermann function = new Ackermann();
            return function.calculate(args);
        }
    },
    F {
        public Object execute(Object... args) {
            Factorial function = new Factorial();
            return function.calculate(args);
        }
    },
    FIB {
        public Object execute(Object... args) {
            Fibonachi function = new Fibonachi();
            return function.calculate(args);
        }
    };

    public abstract Object execute(Object... args);
}

package filetask.funclib;

import java.util.Arrays;

public class AckermanTable {
    private int ARRAY_N = 2;
    private int ARRAY_M = 2;
    private int[][] items;

    public AckermanTable(int m, int n) {
        this.ARRAY_M = m + 1;
        this.ARRAY_N = n + 1;
        this.items = new int[ARRAY_N][ARRAY_M];
        for (int i = 0; i < ARRAY_N; i++) {
            items[i][0] = i + 1;
            items[i][1] = i + 2;
            if (ARRAY_M > 2) {
                items[i][2] = (2 * i) + 3;
            }
        }
    }

    public int getValue(int m, int n) {
        if (m < ARRAY_M && n < ARRAY_N) {
            return items[n][m];
        } else {
            if (m + 1 > ARRAY_M) {
                ARRAY_M = m + 1;
            }
            if (n + 1 > ARRAY_N) {
                ARRAY_N = n + 1;
            }
            grow();
        }

        return 0;
    }

    public void setValue(int m, int n, int item) {
        if (m < ARRAY_M && n < ARRAY_N) {
            items[n][m] = item;
        } else {
            if (m + 1 > ARRAY_M) {
                ARRAY_M = m + 1;
            }
            if (n + 1 > ARRAY_N) {
                ARRAY_N = n + 1;
            }
            grow();

            items[n][m] = item;
        }
    }

    private void grow() {
        int[][] newItems = new int[ARRAY_N][ARRAY_M];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = Arrays.copyOf(items[i], ARRAY_M);
        }
        items = newItems;

        for (int i = ARRAY_N - 1; items[i][0] == 0; i--) {
            items[i][0] = i + 1;
            items[i][1] = i + 2;
            items[i][2] = (2 * i) + 3;
        }
    }
}

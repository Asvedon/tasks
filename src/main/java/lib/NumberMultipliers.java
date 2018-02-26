package lib;

public class NumberMultipliers {
    private int number;
    private SimpleArrayList<Integer> multipliers;

    public NumberMultipliers(int number) {
        this.number = number;
        this.multipliers = new SimpleArrayList<>();
    }

    public int[] getMultipliers() {

        int multiplier = 2;
        while (multiplier * multiplier <= number) {
            if (number % multiplier == 0) {
                multipliers.add(multiplier);
                if (multiplier != (number / multiplier)) {
                    multipliers.add(number / multiplier);
                }
            }
            multiplier++;
        }

        int[] result = new int[multipliers.size()];
        Object[] values = multipliers.toArray();
        for (int i = 0; i < values.length; i++) {
            result[i] = ((Integer) values[i]).intValue();
        }

        return result;
    }
}

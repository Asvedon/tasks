package lib;

public class CombinationsSearch {
    private int input;
    private int[] dividers;
    private CombinationItem[][] variants;

    public CombinationsSearch(int[] dividers) {
        this.dividers = dividers;
    }

    public String[] getVariants(int input) {
        this.input = input;
        initMatrix();
        findVariants();
        return null;
    }

    private void findVariants() {
        SimpleArrayList<String> result = new SimpleArrayList<>();

        result.add(String.format("%nИсходное число %d%n", input));
        for (int i = 0; i < dividers.length; i++) {
            int column = input;
            if (variants[i][column] != null) {
                CombinationItem item = variants[i][column];
                getItemCombinations(item, result);
                result.add("--- // ---");
                if (item.getCount() < 2) {
                    continue;
                }
            }

            int sum = dividers[i];

            while (sum < input) {
                int rowIndex = i - 1;
                column = input - sum;
                while (rowIndex >= 0) {
                    if (variants[rowIndex][column] != null) {
                        getItemCombinations(variants[i][sum], result);
                        CombinationItem item = variants[rowIndex][column];
                        getItemCombinations(item, result);
                        result.add("--- // ---");
                    }
                    rowIndex--;
                }
                sum += dividers[i];
            }
        }

        for (int res = 0; res < result.size(); res++) {
            System.out.println(result.get(res));
        }
    }

    private void getItemCombinations(CombinationItem item, SimpleArrayList<String> result) {
        if (item.getCount() > 0) {
            result.add(String.format("%d по %d коп.", item.getCount(), item.getDividerValue()));
        }
        if (!item.getPreviousDividers().isEmpty()) {
            for (int i = 0; i < item.getPreviousDividers().size(); i++) {
                getItemCombinations(item.getPreviousDividers().get(i), result);
            }
        }
    }

    private void initMatrix() {
        variants = new CombinationItem[dividers.length][input + 1];
        for (int row = 0; row < dividers.length; row++) {
            for (int column = 1; column <= input; column++) {
                if (column < dividers[row]) {
                    continue;
                }
                int residue = column % dividers[row];
                int divCount = column / dividers[row];

                if (residue == 0) {
                    variants[row][column] = new CombinationItem(divCount, column, dividers[row]);
                } else {
                    int rowIndex = row - 1;
                    SimpleArrayList<CombinationItem> dividersIndexes = new SimpleArrayList<>();
                    while (rowIndex >= 0) {
                        if (variants[rowIndex][residue] != null) {
                            dividersIndexes.add(variants[rowIndex][residue]);
                        }
                        rowIndex--;
                    }
                    if (!dividersIndexes.isEmpty()) {
                        CombinationItem item = new CombinationItem(divCount, column, dividers[row]);
                        item.addIndexes(dividersIndexes);
                        variants[row][column] = item;
                    }
                }
            }
        }
    }
}

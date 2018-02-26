package lib;

/**
 * Created by grom on 23/02/2018.
 * Project work
 * author <grom25174@gmail.com>
 */
public class CombinationItem {
    private SimpleArrayList<CombinationItem> previousDividers;
    private int count;
    private int columnValue;
    private int dividerValue;

    public CombinationItem(int count, int columnValue, int dividerValue) {
        this.previousDividers = new SimpleArrayList<>();
        this.count = count;
        this.columnValue = columnValue;
        this.dividerValue = dividerValue;
    }

    public void addPreviousIndex(CombinationItem devider) {
        previousDividers.add(devider);
    }

    public void addIndexes(SimpleArrayList<CombinationItem> indexes) {
        for (int i = 0; i < indexes.size(); i++) {
            previousDividers.add(indexes.get(i));
        }
    }

    public SimpleArrayList<CombinationItem> getPreviousDividers() {
        return previousDividers;
    }

    public int getCount() {
        return count;
    }

    public int getColumnValue() {
        return columnValue;
    }

    public int getDividerValue() {
        return dividerValue;
    }
}

package lib;

public class SimpleSort<T extends Comparable> {
    private SimpleArrayList<T> arrayList;

    public SimpleSort(SimpleArrayList<T> items) {
        this.arrayList = new SimpleArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            this.arrayList.add(items.get(i));
        }
        quickSort(0, arrayList.size() - 1);
    }

    public T getMaxByIndex(int index) {
        return arrayList.get(arrayList.size() - index);
    }

    public T getMinByIndex(int index) {
        return arrayList.get(index - 1);
    }

    private void quickSort(int left, int right) {
        int l = left;
        int r = right;
        int center = (left + right) / 2;
        while (l < r) {
            while (arrayList.get(l).compareTo(arrayList.get(center)) < 0 && l <= right) {
                l++;
            }
            while (arrayList.get(r).compareTo(arrayList.get(center)) > 0 && left <= r) {
                r--;
            }
            if (l <= r) {
                swap(l, r);
                l++;
                r--;
            }
        }
        if (r > left) {
            quickSort(left, r);
        }
        if (l < right) {
            quickSort(l, right);
        }
    }

    private void swap(int left, int right) {
        T leftItem = arrayList.get(left);
        arrayList.set(left, arrayList.get(right));
        arrayList.set(right, leftItem);
    }
}

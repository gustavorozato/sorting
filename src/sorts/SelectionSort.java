package sorts;

public class SelectionSort implements Sorting {
    private static final String SELECTIONSORT_NAME = "Selection sort";
    private int resultArray[];

    @Override
    public String getName() {
        return SELECTIONSORT_NAME;
    }

    @Override
    public int[] getResultArray() {
        return this.resultArray;
    }

    @Override
    public void run(int[] array) {
        int lastArrayIndex = array.length - 1;
        int[] auxArray = Sorting.copyArray(array, array.length);
        sort(auxArray, lastArrayIndex);
        this.resultArray = auxArray;
    }

    private void sort(int[] array, int lastArrayIndex) {
        for (int i = 0; i < lastArrayIndex; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= lastArrayIndex; j++) {
                if (array[j] < array[minIndex]) minIndex = j;
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

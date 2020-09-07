package sorts;

public class BubbleSort implements Sorting {
    private static final String BUBBLESORT_NAME = "Bubble sort";
    private int[] resultArray;

    @Override
    public String getName() {
        return BUBBLESORT_NAME;
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
        boolean swapped;
        for (int i = 0; i < lastArrayIndex; i++) {
            swapped = false;
            for (int j = 0; j < lastArrayIndex - i; j++) {
                if (array[j] > array[j + 1]) {
                    int swapTemp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swapTemp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}

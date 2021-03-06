package sorts;

public class QuickSort implements Sorting {
    private static final String QUICKSORT_NAME = "Quick sort";
    private int[] resultArray;

    @Override
    public String getName() {
        return QUICKSORT_NAME;
    }

    @Override
    public int[] getResultArray() {
        return this.resultArray;
    }

    @Override
    public void run(int[] array) {
        int lastArrayIndex = array.length - 1;
        int[] auxArray = Sorting.copyArray(array, array.length);
        sort(auxArray, 0, lastArrayIndex);
        this.resultArray = auxArray;
    }

    private void sort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }
}

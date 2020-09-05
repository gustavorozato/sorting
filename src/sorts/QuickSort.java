package sorts;

public class QuickSort implements Sorting {
    private static final String QUICKSORT_NAME = "Quicksort";

    @Override
    public String name() {
        return QUICKSORT_NAME;
    }

    @Override
    public int[] run(int array[]) {
        int lastArrayIndex = array.length - 1;
        int[] auxArray = new int[array.length];

        System.arraycopy(array, 0, auxArray, 0, lastArrayIndex);
        sort(auxArray, 0, lastArrayIndex);

        return auxArray;
    }

    private void sort(int array[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    private int partition(int array[], int begin, int end) {
        int pivot = array[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }
}

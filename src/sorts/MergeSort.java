package sorts;

public class MergeSort implements Sorting {
    private static final String MERGESORT_NAME = "Merge sort";
    private int[] resultArray;

    @Override
    public String getName() {
        return MERGESORT_NAME;
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

    private void merge(int[] array, int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        if (sizeLeft >= 0) System.arraycopy(array, left, leftArray, 0, sizeLeft);
        if (sizeRight >= 0) System.arraycopy(array, mid + 1, rightArray, 0, sizeRight);

        int i = 0, j = 0;

        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(array, left, mid);
            sort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }
}

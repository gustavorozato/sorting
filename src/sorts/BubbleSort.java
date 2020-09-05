package sorts;

public class BubbleSort implements Sorting {
    private static final String BUBBLESORT_NAME = "Bubblesort";
    private int resultArray[];

    @Override
    public String getName() {
        return BUBBLESORT_NAME;
    }

    @Override
    public int[] getResultArray() {
        return this.resultArray;
    }

    @Override
    public void run(int array[]) {
        int lastArrayIndex = array.length - 1;
        int[] auxArray = new int[array.length];

        System.arraycopy(array, 0, auxArray, 0, lastArrayIndex);
        sort(auxArray, lastArrayIndex);

        this.resultArray = auxArray;
    }

    private void sort(int array[], int lastArrayIndex) {
        for (int i = 0; i <= lastArrayIndex; i++) {
            for (int j = 0; j <= lastArrayIndex - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
}

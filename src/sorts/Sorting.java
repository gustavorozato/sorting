package sorts;

public interface Sorting {
    void run(int[] array);
    String getName();
    int[] getResultArray();

    static int[] copyArray(int[] toCopy, int arraySize) {
        int[] auxArray = new int[arraySize];
        System.arraycopy(toCopy, 0, auxArray, 0, arraySize);
        return auxArray;
    }
}

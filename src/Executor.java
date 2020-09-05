import sorts.BubbleSort;
import sorts.QuickSort;
import sorts.Sorting;
import utils.File;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    private static final String DEFAULT_STRING_ARRAY = "6,5,1,2,4,3";
    private final List<Sorting> sortingAlgorithms;
    private final int array[];
    private final boolean showSortedArray;

    private Executor(List<Sorting> sortingAlgorithms, int[] array, boolean showSortedArray) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.array = array;
        this.showSortedArray = showSortedArray;
    }

    public static void main(String[] args) {
        if (args.length < 1) return;

        File file = File.getFileInstance(args[0]);

        int[] array = File.getLineNumbers(file.getFileLine().orElse(DEFAULT_STRING_ARRAY));

        List<Sorting> sortingAlgorithms = new ArrayList<>();
        sortingAlgorithms.add(new BubbleSort());
        sortingAlgorithms.add(new QuickSort());

        Executor executor = new Executor(sortingAlgorithms, array, true);
        executor.run();
    }

    private void run() {
        long startTime;
        for (Sorting sorting : sortingAlgorithms) {
            startTime = System.nanoTime();
            sorting.run(this.array);
            System.out.println(String.format("%s took %d nanoseconds", sorting.getName(), System.nanoTime() - startTime));

            if (this.showSortedArray) {
                this.printResult(sorting);
            }
        }
    }

    private void printResult(Sorting sorting) {
        StringBuilder builder = new StringBuilder();
        System.out.println(String.format("Showing sorted array for %s", sorting.getName()));
        for (int value : sorting.getResultArray()) {
            builder.append(value).append(" ");
        }
        System.out.println(builder.toString());
    }
}

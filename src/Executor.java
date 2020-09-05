import sorts.QuickSort;
import sorts.Sorting;
import utils.File;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    private static final String DEFAULT_STRING_ARRAY = "6,5,1,2,4,3";
    private final List<Sorting> sortingAlgorithms;
    private final int array[];

    private Executor(List<Sorting> sortingAlgorithms, int[] array) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.array = array;
    }

    public static void main(String[] args) {
        if (args.length < 1) return;

        File file = File.getFileInstance(args[0]);

        int[] array = File.getLineNumbers(file.getFileLine().orElse(DEFAULT_STRING_ARRAY));

        List<Sorting> sortingAlgorithms = new ArrayList<>();
        sortingAlgorithms.add(new QuickSort());

        Executor executor = new Executor(sortingAlgorithms, array);
        executor.run();
    }

    private void run() {
        long startTime;
        for (Sorting sort : sortingAlgorithms) {
            startTime = System.nanoTime();
            sort.run(this.array);
            System.out.println(String.format("%s took %d nanoseconds", sort.name(), System.nanoTime() - startTime));
        }
    }
}

import utils.File;

public class Executor {

    private static final String DEFAULT_STRING_ARRAY = "6,5,1,2,4,3";

    public static void main(String[] args) {
        if (args.length < 1) return;

        File file = File.getFileInstance(args[0]);

        int[] array = File.getLineNumbers(file.getFileLine().orElse(DEFAULT_STRING_ARRAY));

        for (int a : array) {
            System.out.println(a);
        }
    }
}

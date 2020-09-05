import utils.File;

public class Executor {
    public static void main(String[] args) {
        if (args.length < 1) return;

        File file = File.getFileInstance(args[0]);
        file.getFileLine();
    }
}

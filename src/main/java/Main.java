import analyzer.IpaAnalyzer;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("");
            System.exit(2);
        }

        String path = args[0];
        String output = null;
        if (args.length >= 2) {
            output = args[1];
        }

        System.out.println("Analysis begins.");

        long start = System.currentTimeMillis();

        IpaAnalyzer analyzer = new IpaAnalyzer();
        int result = analyzer.analyze(path);
        // Analyzer analyzer = new Analyzer();
        // int analysisResult = analyzer.analyze(path);

        System.out.println("Analysis ends.");

        long end = System.currentTimeMillis();

        System.out.println("Analysis time is " + (end - start) + " msec.");
    }
}

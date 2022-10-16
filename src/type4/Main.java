package type4;

import java.io.File;

public class Main {
    public static File run(String filename) {
        System.out.println("Main类---");

        String outFileName = "E:\\output.txt";

        Input input = new Input();
//        input.input("E:\\input.txt");
        input.input(filename);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output(outFileName);

        return new File(outFileName);
    }
}

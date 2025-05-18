import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing");

        // read file

        String file;
        try {
            String path = "./src/Calculator.java";
            file = Files.readString(Path.of(path));

            // System.out.println("file: " + file);
            // get basic halstead values
            HalsteadMetrics hal = new HalsteadMetrics();
            int[] result = hal.calculateHalstead(file);
            // additional values
            System.out.println("--------" + path + "--------");
            System.out.println(
                    "n1 = " + result[0] + "\nn2 = " + result[1] + "\nN1 = " + result[2] + "\nN2 = "
                            + result[3]);
            double programLength = result[2] + result[3]; // N1 + N2
            double vocabularySize = result[0] + result[1]; // n1 + n2
            double programVolume = programLength * (Math.log((double) vocabularySize) / Math.log(2));
            double difficulty = (result[0] / 2) * (result[3] / result[1]);
            double effort = programVolume * difficulty;
            double level = 1 / difficulty;
            double implementationTime = effort / 18;
            double bugs = (Math.pow(effort, (2f / 3f))) / 3000;
            System.out.println("operators = " + hal.receivedOperators);
            System.out.println("operands = " + hal.receivedOperands);

            System.out.println(
                    "\nprogram Length = " + programLength +
                            "\nvocabulary Size = " + vocabularySize +
                            "\nprogram volume = " + programVolume +
                            "\ndifficulty = " + difficulty +
                            "\nlevel = " + level +
                            "\neffort = " + effort +
                            "\nimplementation Time = " + implementationTime + " sec" +
                            "\nbugs = " + bugs);

            // this is terribly structured code !
        } catch (IOException e) {
            System.out.println("no file found!");
        }
      System.out.println("finished");
        //  runTests();

    }

    private static void runTests() {
        Result result = JUnitCore.runClasses(TestClass.class);
        for (Failure f : result.getFailures()) {
            System.err.println("test failed: " + f.toString());
        }
    }

}
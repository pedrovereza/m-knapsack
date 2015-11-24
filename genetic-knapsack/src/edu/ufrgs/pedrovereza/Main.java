package edu.ufrgs.pedrovereza;

import static java.util.Arrays.asList;
import edu.ufrgs.pedrovereza.domain.Instance;
import edu.ufrgs.pedrovereza.domain.KnapsackSolver;
import edu.ufrgs.pedrovereza.domain.io.InstanceParser;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    static Instance instance;

    public static void main(String[] args) {

        String filePath;
        Integer populationSize = 50;

        if (args.length == 0) {
            System.out.println("Assuming population size: 50. Reading from standard input");
        }

        if (args.length == 1) {
            System.out.println("Usage: -file <filepath> -pop <population-size>");
            return;
        }

        List<String> argsList = asList(args);

        int indexPop = argsList.indexOf("-pop");

        if (indexPop != -1 && indexPop != args.length - 1 && indexPop % 2 == 0) {
            try {
                populationSize = Integer.parseInt(args[indexPop + 1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value for population size. Assuming 50.");
            }

        }

        int indexFile = argsList.indexOf("-file");

        if (indexFile != -1 && indexFile != args.length - 1 && indexFile % 2 == 0) {

            filePath = args[indexFile + 1];

            try {
                instance = new InstanceParser().parseFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found at: " + args[0]);
            }
        } else {
            System.out.println("Reading from standard input");
            instance = new InstanceParser().readFromStandardIO();
        }

        System.out.println(new KnapsackSolver(instance, populationSize).solve());

    }
}

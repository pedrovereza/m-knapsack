package edu.ufrgs.pedrovereza;

import edu.ufrgs.pedrovereza.domain.Instance;
import edu.ufrgs.pedrovereza.domain.KnapsackSolver;
import edu.ufrgs.pedrovereza.domain.io.InstanceParser;

import java.io.FileNotFoundException;

public class Main {

    static Instance instance;

    public static void main(String[] args) {

        try {
            instance = new InstanceParser().parseFile
                    ("/Users/pvereza/personal/ufrgs/otimizacao-combinatoria/selected_mdkp_instances/OR30x500-0.25_1.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        System.out.println(new KnapsackSolver(instance).solve());

        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println(estimatedTime / 1000.0);
    }
}

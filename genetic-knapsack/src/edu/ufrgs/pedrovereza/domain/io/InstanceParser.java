package edu.ufrgs.pedrovereza.domain.io;

import edu.ufrgs.pedrovereza.domain.Dimension;
import edu.ufrgs.pedrovereza.domain.Instance;
import edu.ufrgs.pedrovereza.domain.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstanceParser {
    private Scanner scanner;

    public Instance parseFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        scanner = new Scanner(file);

        List<Item> items = new ArrayList<Item>();
        List<Dimension> dimensions = new ArrayList<Dimension>();

        int numberOfItems = scanner.nextInt();
        int numberOfDimensions = scanner.nextInt();
        scanner.nextInt(); //optimal


        for (int i = 0; i < numberOfItems; ++i) {
            items.add(new Item(i, scanner.nextInt()));
        }

        for (int i = 0; i < numberOfDimensions; ++i) {
            for (int j = 0; j < numberOfItems; ++j) {
                items.get(j).addDimension(new Dimension(i, scanner.nextInt()));
            }
        }

        for (int i = 0; i < numberOfDimensions; ++i) {
            dimensions.add(new Dimension(i, scanner.nextInt()));
        }


        return new Instance(items, dimensions);
    }

}

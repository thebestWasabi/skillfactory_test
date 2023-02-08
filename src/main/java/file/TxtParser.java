package file;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtParser {

    public static  <T> List<T> parseFileToObjectList(String fileName, String separator, Class<T> modelClass) throws Exception {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            List<T> cities = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(separator);
                Constructor<T> constructor = modelClass.getConstructor(String[].class);
                cities.add(constructor.newInstance(new Object[]{splitLine}));
            }
            return cities;
        }
    }
}

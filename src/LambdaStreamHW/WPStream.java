package LambdaStreamHW;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WPStream {

    public static void main(String[] args) {

        File file = new File("resources/wp.txt");

        Map<String, Long> map = null;
        try (Stream<String> stream = Files.lines(file.toPath()).parallel()) {
            map = stream
                    .map(line -> line
                            .replaceAll("'", "")
                            .replaceAll("[0-9]", "")
                            .replaceAll("\\p{Punct}", " ")
                            .toLowerCase()
                            .trim())
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(word -> !"".equals(word))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .parallelStream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .limit(10)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
}

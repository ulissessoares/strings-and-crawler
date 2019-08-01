package idwall.desafio.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IdwallJustifier {

    // justifica uma linha, distribuindo os espaços em branco extras igualmente aos espaçamentos já existentes
    // a regra de distribuição dos espaçamentos é alternar entre os espaçamentos de tamanho menor e maior
    // começando sempre com um espaçamento de tamanho maior e completando os ultimos espacamentos com
    public static String justify(String line, Integer limit) {
        if(line.isEmpty())
            return line;


        List<String> words =  Arrays.asList(line.split(" "));

        Integer numberOfSpaces = words.size() - 1;
        Integer complementToLimit = limit - line.length();
        Integer defaultSpaceSize = 0;
        Integer quantityOfBiggerSpaces = 0;

        if (numberOfSpaces > 0) {
            defaultSpaceSize = (complementToLimit / numberOfSpaces) + 1;
            quantityOfBiggerSpaces = complementToLimit % numberOfSpaces;
        } else {
            defaultSpaceSize = complementToLimit / 2;
            quantityOfBiggerSpaces = complementToLimit % 2;
        }

        String defaultSpace = Stream.generate(() -> (String.valueOf(" "))).limit(defaultSpaceSize).collect(Collectors.joining());

        String biggerSpace = defaultSpace + " ";
        List<String> spaces = new ArrayList<>();

        if (quantityOfBiggerSpaces <= numberOfSpaces / 2) {

            spaces.addAll(Collections.nCopies(numberOfSpaces, defaultSpace));
            List<Integer> biggerSpaceIndex = IntStream.range(1, numberOfSpaces + 1)
                    .filter(x -> x % 2 == 1)
                    .limit(quantityOfBiggerSpaces)
                    .boxed()
                    .collect(Collectors.toList());

            biggerSpaceIndex.forEach(x -> spaces.set(x - 1, biggerSpace));

        } else {

            spaces.addAll(Collections.nCopies(numberOfSpaces, biggerSpace));
            List<Integer> biggerSpaceIndex = IntStream.range(1, numberOfSpaces + 1)
                    .filter(x -> x % 2 == 0)
                    .limit(numberOfSpaces - quantityOfBiggerSpaces)
                    .boxed()
                    .collect(Collectors.toList());

            biggerSpaceIndex.forEach(x -> spaces.set(x - 1, defaultSpace));
        }


        return joinWordsAndSpaces(words, spaces);
    }

    public static String joinWordsAndSpaces(List<String> words, List<String> spaces) {
        List<String> wordsAndSpaces = new ArrayList<>();
        Integer indexWords = 0;
        Integer indexSpaces = 0;

        while(indexWords < words.size()) {
            if (indexWords == indexSpaces ) {
                wordsAndSpaces.add(words.get(indexWords));
                indexWords++;
            } else if (indexWords > indexSpaces) {
                wordsAndSpaces.add(spaces.get(indexSpaces));
                indexSpaces++;
            }
        }

        return  String.join("", wordsAndSpaces);

    }
}
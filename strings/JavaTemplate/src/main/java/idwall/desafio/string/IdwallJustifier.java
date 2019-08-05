package idwall.desafio.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IdwallJustifier implements  StringJustifier{


    private final String SINGLE_CHAR_SPACE = " ";
    private Integer limit;

    public IdwallJustifier(Integer limit) {
        this.limit = limit;
    }

    // Justifica a linha
    // calcula quantos caracteres faltam para completar o tamanho da linha
    // calcula o tamanho dos espaços entre as palavras e como é feita a distribuição desses espaços
    // calcula como distribuir os espaços de tamanho diferentes entre as palavras, criando uma lista com esses espaços ja ordenados
    // faz join entre as palavras e os espaços com tamanho ajustado
    public String justify(String line) {
        if(line.isEmpty())
            return line;


        List<String> words =  Arrays.asList(line.split("\\s+"));

        Integer numberOfSpaces = words.size() - 1;
        Integer complementToLimit = calculateComplementToLimit(words, numberOfSpaces, limit);
        Integer smallSpaceSize = 0;
        Integer quantityOfBigSpaces = 0;

        if (numberOfSpaces > 0) {
            smallSpaceSize = (complementToLimit / numberOfSpaces) + 1;
            quantityOfBigSpaces = complementToLimit % numberOfSpaces;
        } else {
            smallSpaceSize = complementToLimit / 2;
            quantityOfBigSpaces = complementToLimit % 2;
            numberOfSpaces = 2;
        }

        String smallSpace = Stream.generate(() -> (String.valueOf(SINGLE_CHAR_SPACE))).limit(smallSpaceSize).collect(Collectors.joining());

        String bigSpace = smallSpace + SINGLE_CHAR_SPACE;
        List<String> spaces;

        if (quantityOfBigSpaces <= numberOfSpaces / 2)
            spaces = generateSpacesArray(numberOfSpaces, smallSpace, bigSpace, x -> x % 2 == 1, quantityOfBigSpaces);
        else
            spaces = generateSpacesArray(numberOfSpaces, bigSpace, smallSpace, x -> x % 2 == 0, numberOfSpaces - quantityOfBigSpaces);


        return joinWordsAndSpaces(words, spaces);
    }

    protected String joinWordsAndSpaces(List<String> words, List<String> spaces) {
        List<String> wordsAndSpaces = new ArrayList<>();
        Integer indexWords = 0;
        Integer indexSpaces = 0;

        if (words.size() > spaces.size()) {
            while (indexWords < words.size()) {
                if (indexWords == indexSpaces) {
                    wordsAndSpaces.add(words.get(indexWords));
                    indexWords++;
                } else if (indexWords > indexSpaces) {
                    wordsAndSpaces.add(spaces.get(indexSpaces));
                    indexSpaces++;
                }
            }
        } else if (spaces.size() > words.size()) {
            while (indexSpaces < spaces.size()) {
                if (indexSpaces == indexWords) {
                    wordsAndSpaces.add(spaces.get(indexSpaces));
                    indexSpaces++;
                } else if (indexSpaces > indexWords) {
                    wordsAndSpaces.add(words.get(indexWords));
                    indexWords++;
                }
            }
        }

        return  String.join("", wordsAndSpaces);

    }

    protected List<String> generateSpacesArray(Integer numberOfSpaces, String defaultSpace, String otherSpace, IntPredicate filterPredicate, Integer bigSpacesIndexesSize) {
        List<String> spaces = new ArrayList<>();

        spaces.addAll(Collections.nCopies(numberOfSpaces, defaultSpace));
        List<Integer> biggerSpaceIndex = IntStream.range(1, numberOfSpaces + 1)
                .filter(filterPredicate)
                .limit(bigSpacesIndexesSize)
                .boxed()
                .collect(Collectors.toList());

        biggerSpaceIndex.forEach(x -> spaces.set(x - 1, otherSpace));
        return spaces;
    }

    protected Integer calculateComplementToLimit(List<String> words, Integer numberOfSpaces, Integer limit) {
        Integer totalLength = words.stream().mapToInt(String::length).sum() + numberOfSpaces;
        return limit - totalLength;
    }


}
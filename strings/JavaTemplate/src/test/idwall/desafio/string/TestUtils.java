package idwall.desafio.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {

    public static void wrappedTextShouldHaveMoreThanOrSameLinesThatUnwrappedText(String wrappedText, String unwrappedText) {
        List<String> wrappedLines = getLines(wrappedText);
        List<String> unwrappedLines = getLines(unwrappedText);

        assert (wrappedLines.size() >= unwrappedLines.size());
    }

    public static void wrappedTextLinesShouldBeSmallerOrEqualThanLineLimit(String wrappedText, Integer limit) {
        List<String> wrappedLines = getLines(wrappedText);
        wrappedLines.forEach(line -> {assert(line.length() <= limit);});
    }

    public static void wrappedTextNotBlankLinesShouldHaveEqualLengthThanLineLimit(String wrappedText, Integer limit) {
        List<String> wrappedLines = getLines(wrappedText);
        wrappedLines.forEach(line -> {
            if (!line.isEmpty())
                assert(line.length() == limit);
        });
    }

    public static void wrappedTextShouldHaveTheSameNumerOfBlankLinesThatOfTheUnwrappedText(String wrappedText, String unwrappedText) {
        List<String> wrappedBlankLines = getLines(wrappedText).stream().filter(line -> line.isEmpty()).collect(Collectors.toList());
        List<String> unwrappedBlankLines = getLines(unwrappedText).stream().filter(line -> line.isEmpty()).collect(Collectors.toList());

        System.out.println("Wrapped Blank Lines size: " + String.valueOf(wrappedBlankLines.size()));
        System.out.println("Unwrapped Blank Lines size: " + String.valueOf(unwrappedBlankLines.size()));
        assert (wrappedBlankLines.size() == unwrappedBlankLines.size());
    }

    public static void wrappedTextShouldHaveTheSameWordCountThatOfUnwrappedText(String wrappedText, String unwrappedText) {
        List<String> wrappedTextWords = getAllWords(wrappedText);
        List<String> unwrappedTextWords = getAllWords(unwrappedText);


        System.out.println("Wrapped text words size: " + String.valueOf(wrappedTextWords.size()));
        System.out.println("Unwrapped text words size: " + String.valueOf(unwrappedTextWords.size()));
        assert (wrappedTextWords.size() == unwrappedTextWords.size());
    }

    public static List<String> getLines(String text) {
        List<String> lines = new ArrayList<>();
        lines.addAll(Arrays.asList(text.split("\\r?\\n", -1)));

//        if(String.valueOf(text.charAt(text.length() - 1)).matches("\\r?\\n"))
//            lines.add("");

        return lines;
    }


    public static List<String> getAllWords(String text) {
        text = text.replaceAll("[\\r?\\n]+", " ");
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(text.split("\\S+")));

        return words;
    }
}

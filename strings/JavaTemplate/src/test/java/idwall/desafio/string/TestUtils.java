package idwall.desafio.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {


    public static List<String> getLines(String text) {
        List<String> lines = new ArrayList<>();
        lines.addAll(Arrays.asList(text.split("\\r?\\n", -1)));

        return lines;
    }

    public static List<String> getAllWords(String text) {
        text = text.replaceAll("[\\r?\\n]+", " ");
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(text.split("\\S+")));

        return words;
    }
}

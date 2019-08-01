package idwall.desafio.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdwallFormatterTest {

    private final String ONE_BLANK_LINE_TEXT = "";
    private final String THREE_BLANK_LINES_BLANK_LINE_TEXT = "\n\n";


//    @Test
//    public void shouldCalculateCorretCuttingIndexForLine() {
//        String line = "example of a line";
//        Integer limit = 12;
//
//        IdwallFormatter formatter = new IdwallFormatter(12, false);
//        Integer cutIndex = formatter.calculateCuttingIndex(line, limit);
//        System.out.println(cutIndex);
//    }
//
//    @Test
//    public void shouldCalculateCorretCuttingIndexForLineEndingWithWhiteSpace() {
//        String line = "example of a line";
//        Integer limit = 13;
//
//        IdwallFormatter formatter = new IdwallFormatter(13, false);
//        Integer cutIndex = formatter.calculateCuttingIndex(line, limit);
//        System.out.println(cutIndex);
//    }
//
//    @Test
//    public void test() {
//        IdwallFormatter formatter = new IdwallFormatter(40, true);
//        String result = formatter.format(DEFAULT_INPUT_TEXT);
//        System.out.println(result);
//    }
//
//    @Test
//    public void testFirstLine() {
//        String result = FIRST_LINE.substring(0, 40);
//        System.out.println(result);
//        System.out.println(result.substring(40).length());
//
//    }
//
//    @Test
//    public void test2FirstLine() {
//        IdwallFormatter formatter = new IdwallFormatter(41, false);
//        System.out.println(formatter.calculateCuttingIndex(FIRST_LINE, 41));
//
//    }
//
//    @Test
//    public void test6() {
//        List<String> words = getAllWords(DEFAULT_INPUT_TEXT);
//        System.out.println(words.size());
//    }

    @Test
    public void wrapOneBlankLineTextShouldResultInOutputWithOneBlankLine() {
        IdwallFormatter formatter = new IdwallFormatter(40, false);
        String wrappedText = formatter.format(ONE_BLANK_LINE_TEXT);
        assert (ONE_BLANK_LINE_TEXT.equals(wrappedText));
    }

    @Test
    public void wrapSeveralBlankLinesTextShouldResultInOutputWithSameNumberOfBlankLines() {
        IdwallFormatter formatter = new IdwallFormatter(40, false);
        String wrappedText = formatter.format(THREE_BLANK_LINES_BLANK_LINE_TEXT);
        assert (TestUtils.getLines(THREE_BLANK_LINES_BLANK_LINE_TEXT).size() == TestUtils.getLines(wrappedText).size());
    }

    @Test
    public void wrapATextWithASingleLineSmallerThanTheLimitWithoutJustificationMustResultInSameText() {
        IdwallFormatter formatter = new IdwallFormatter(40, false);
        String textSampleWithLenghtSmallerThan40Chars = "This is a example of text";
        String result = formatter.format(textSampleWithLenghtSmallerThan40Chars);
        assert (textSampleWithLenghtSmallerThan40Chars.equals(result));
    }

    @Test
    public void wrapATextWithASingleLineOfLengthEqualToTheLimitWithoutJustificationMustResultInSameText() {
        IdwallFormatter formatter = new IdwallFormatter(40, false);
        String textWith40Chars = "In the beginning God created the heavens";
        String result = formatter.format(textWith40Chars);
        assert (textWith40Chars.equals(result));
    }


}

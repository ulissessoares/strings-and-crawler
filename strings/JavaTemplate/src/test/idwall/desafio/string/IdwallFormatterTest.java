package idwall.desafio.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdwallFormatterTest {

    private static String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

    private static String FIRST_LINE = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n";

    private static String SECOND_LINE = "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

    @Test
    public void shouldCalculateCorretCuttingIndexForLine() {
        String line = "example of a line";
        Integer limit = 12;

        IdwallFormatter formatter = new IdwallFormatter(12, false);
        Integer cutIndex = formatter.calculateCuttingIndex(line, limit);
        System.out.println(cutIndex);
    }

    @Test
    public void shouldCalculateCorretCuttingIndexForLineEndingWithWhiteSpace() {
        String line = "example of a line";
        Integer limit = 13;

        IdwallFormatter formatter = new IdwallFormatter(13, false);
        Integer cutIndex = formatter.calculateCuttingIndex(line, limit);
        System.out.println(cutIndex);
    }

    @Test
    public void test() {
        IdwallFormatter formatter = new IdwallFormatter(40, true);
        String result = formatter.format(DEFAULT_INPUT_TEXT);
        System.out.println(result);
    }

    @Test
    public void testFirstLine() {
        String result = FIRST_LINE.substring(0, 40);
        System.out.println(result);
        System.out.println(result.substring(40).length());

    }

    @Test
    public void test2FirstLine() {
        IdwallFormatter formatter = new IdwallFormatter(41, false);
        System.out.println(formatter.calculateCuttingIndex(FIRST_LINE, 41));

    }

    @Test
    public void shouldJustifyLine() {
        String line =  "\"day,\" and the darkness he called";
        String justifiedLine = "\"day,\"   and  the   darkness  he  called";
        String result = IdwallJustifier.justify(line, 40);
        System.out.println(result);
        System.out.println(justifiedLine);

    }

    @Test
    public void shouldJustifyLine2() {
        String line =  "was good, and he separated the light";
        String justifiedLine = "was  good, and  he separated  the  light";
        String result = IdwallJustifier.justify(line, 40);
        System.out.println(result);
        System.out.println(justifiedLine);

    }

    @Test
    public void teste3() {
        System.out.println(String.valueOf(7/5));
        System.out.println(String.valueOf(7%7));
    }

    @Test
    public void teste4() {
        IntStream.range(1, 7).forEach(x -> System.out.println(x));
        IntStream.range(1, 7).filter(x -> x % 2 == 1).forEach(x -> System.out.println(x));
        List<Integer> biggerSpaceIndex = IntStream.range(1, 6).filter(x -> x % 2 == 1).limit(4).boxed().collect(Collectors.toList());
    }

    @Test
    public void teste5() {
        List<String> words = Arrays.asList("eu", "tu", "vc", "ele", "eles");
        List<String> spaces = Arrays.asList("   ", "  ", "   ", "  ");

        System.out.println(IdwallJustifier.joinWordsAndSpaces(words, spaces));
    }


    public void shouldHave


}

package idwall.desafio.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdwallJustifierTest {

    @Test
    public void justifyEmptyLineShouldReturnEmptyLine() {
        String lineToJustify = "";
        String result = IdwallJustifier.justify(lineToJustify, 10);
        assert (result.equals(lineToJustify));
    }

    @Test
    public void lineDontNeedJustification() {
        String line = "In the beginning God created the heavens";
        String expected = line;
        runAndAssert(line, expected, 40);
    }

    @Test
    public void justifiedLineHasMoreSmallSpacesThanBigSpaces() {
        String line = "and the earth. Now the earth was";
        String expected = "and   the  earth.   Now  the  earth  was";
        runAndAssert(line, expected, 40);
    }

    @Test
    public void justifiedLineHasMoreBigSpacesThanSmallSpaces() {
        String line = "was good, and he separated the light";
        String expected = "was  good, and  he separated  the  light";
        runAndAssert(line, expected, 40);
    }

    @Test
    public void justifiedLineHasAllSpacesSameSize() {
        String line = "this is a sample example line.";
        String expected = "this   is   a   sample   example   line.";
        runAndAssert(line, expected, 40);
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

    @Test
    public void test6() {
        List<String> words =  Arrays.asList("word".split(" "));
        words.forEach(System.out::println);
        System.out.println(words.size());


    }

    @Test
    public void test7() {
        String lineToJustify = "word";
        String result = IdwallJustifier.justify(lineToJustify, 10);
        assert (result.equals(lineToJustify));
    }

    private void runAndAssert(String line, String expected, Integer limit) {
        String result = IdwallJustifier.justify(line, limit);
        assert (expected.equals(result));
    }



}

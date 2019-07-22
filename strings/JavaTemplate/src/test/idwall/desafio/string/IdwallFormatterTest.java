package idwall.desafio.string;

import org.junit.Test;

public class IdwallFormatterTest {

    private static String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day." + "\n";

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
        IdwallFormatter formatter = new IdwallFormatter(80, false);
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

}

package idwall.desafio.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IdwallJustifierTest {

    @Test
    public void justifyEmptyLineShouldReturnEmptyLine() {
        String lineToJustify = "";
        IdwallJustifier justifier = new IdwallJustifier(10);
        String result = justifier.justify(lineToJustify);
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
        String expected = "\"day,\"   and  the   darkness  he  called";
        runAndAssert(line, expected, 40);

    }

    @Test
    public void shouldJustifyLine2() {
        String line =  "was good, and he separated the light";
        String expected = "was  good, and  he separated  the  light";
        runAndAssert(line, expected, 40);

    }

    @Test
    public void shouldJustifyLineWithMultipleConsecutiveSpaces() {
//        this   is  a  sample      example  line.
//        this is a sample   example line.
        String line = "this is a sample   example line.";
        String expected = "this   is   a   sample   example   line.";
        runAndAssert(line, expected, 40);
    }

    private void runAndAssert(String line, String expected, Integer limit) {
        IdwallJustifier justifier = new IdwallJustifier(limit);
        String result = justifier.justify(line);
        System.out.println(result);
        assert (expected.equals(result));
    }



}

package idwall.desafio.string;

import org.junit.Test;

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

    private void runAndAssert(String line, String expected, Integer limit) {
        String result = IdwallJustifier.justify(line, limit);
        assert (expected.equals(result));
    }

}

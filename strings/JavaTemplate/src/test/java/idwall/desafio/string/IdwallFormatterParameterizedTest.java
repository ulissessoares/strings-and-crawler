package idwall.desafio.string;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;


@RunWith(Parameterized.class)
public class IdwallFormatterParameterizedTest {

        String testCaseDescription;
        String unwrappedText;
        String expectedWrappedText;
        Integer wrapLimit;
        Boolean justify;

        IdwallFormatter formatter;
        String wrappedText;

        public IdwallFormatterParameterizedTest(String testCaseDescritpion, Boolean justify, Integer wrapLimit, String unwrappedText, String expectedWrappedText) {
                this.testCaseDescription = testCaseDescritpion;
                this.unwrappedText = unwrappedText;
                this.expectedWrappedText = expectedWrappedText;
                this.wrapLimit = wrapLimit;
                this.justify = justify;
        }

        @Parameterized.Parameters(name = "Test Case {index}: {0}")
        public static Collection wraperTextData() {
                return Arrays.asList(new Object[][] {
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_1_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_1_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_1_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_1_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_1_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_2_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_2_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_2_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_2_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_2_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_3_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_3_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_3_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_3_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_3_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_4_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_4_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_4_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_4_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_4_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_5_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_5_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_5_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_5_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_5_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_6_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_6_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_6_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_6_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_6_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_7_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_7_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_7_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_7_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_7_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_8_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_8_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_8_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_8_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_8_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_9_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_9_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_9_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_9_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_9_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_10_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_10_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_10_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_10_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_10_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_11_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_11_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_11_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_11_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_11_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_12_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_12_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_12_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_12_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_12_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_13_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_13_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_13_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_13_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_13_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_14_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_14_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_14_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_14_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_14_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_15_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_15_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_15_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_15_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_15_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_16_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_16_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_16_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_16_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_16_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_17_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_17_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_17_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_17_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_17_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_18_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_18_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_18_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_18_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_18_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_19_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_19_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_19_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_19_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_19_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_20_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_20_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_20_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_20_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_20_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_21_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_21_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_21_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_21_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_21_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_22_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_22_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_22_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_22_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_22_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_23_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_23_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_23_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_23_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_23_EXPECTED_RESULT},
                        {IdwallFormatterParameterizedTestCases.TEST_CASE_24_DESCRIPTION, IdwallFormatterParameterizedTestCases.TEST_CASE_24_JUSTIFY, IdwallFormatterParameterizedTestCases.TEST_CASE_24_LINE_LIMIT, IdwallFormatterParameterizedTestCases.TEST_CASE_24_INPUT_DATA, IdwallFormatterParameterizedTestCases.TEST_CASE_24_EXPECTED_RESULT}
                });
        }

        @Before
        public void initialize() {
                formatter = new IdwallFormatter(wrapLimit, justify);
                wrappedText = formatter.format(unwrappedText);
        }

        @Test
        public void wrappedTextShouldBeEqualExpectedWrappedText() {
                System.out.println("Wrapped Text:");
                System.out.println(wrappedText);
                System.out.println("Expected Wrapped Text:");
                System.out.println(expectedWrappedText);

                assert expectedWrappedText.equals(wrappedText);
        }

        @Test
        public void wrappedTextShouldHaveMoreThanOrSameLinesThatUnwrappedText() {
                List<String> wrappedLines = TestUtils.getLines(wrappedText);
                List<String> unwrappedLines = TestUtils.getLines(unwrappedText);

                assert (wrappedLines.size() >= unwrappedLines.size());
        }

        @Test
        public void wrappedTextLinesShouldBeSmallerOrEqualThanLineLimit() {
                List<String> wrappedLines = TestUtils.getLines(wrappedText);
                wrappedLines.forEach(line -> {assert(line.length() <= wrapLimit);});
        }

        @Test
        public void wrappedTextNotBlankLinesShouldHaveEqualLengthThanLineLimit() {
                assumeTrue(justify);
                List<String> wrappedLines = TestUtils.getLines(wrappedText);
                wrappedLines.forEach(line -> {
                        if (!line.isEmpty())
                                assert(line.length() == wrapLimit);
                });
        }

        @Test
        public void wrappedTextShouldHaveTheSameNumerOfBlankLinesThatOfTheUnwrappedText() {
                List<String> wrappedBlankLines = TestUtils.getLines(wrappedText).stream().filter(line -> line.isEmpty()).collect(Collectors.toList());
                List<String> unwrappedBlankLines = TestUtils.getLines(unwrappedText).stream().filter(line -> line.isEmpty()).collect(Collectors.toList());

                System.out.println("Wrapped Blank Lines size: " + String.valueOf(wrappedBlankLines.size()));
                System.out.println("Unwrapped Blank Lines size: " + String.valueOf(unwrappedBlankLines.size()));
                assert (wrappedBlankLines.size() == unwrappedBlankLines.size());
        }

        @Test
        public void wrappedTextShouldHaveTheSameWordCountThatOfUnwrappedText() {
                List<String> wrappedTextWords = TestUtils.getAllWords(wrappedText);
                List<String> unwrappedTextWords = TestUtils.getAllWords(unwrappedText);


                System.out.println("Wrapped text words size: " + String.valueOf(wrappedTextWords.size()));
                System.out.println("Unwrapped text words size: " + String.valueOf(unwrappedTextWords.size()));
                assert (wrappedTextWords.size() == unwrappedTextWords.size());
        }



}


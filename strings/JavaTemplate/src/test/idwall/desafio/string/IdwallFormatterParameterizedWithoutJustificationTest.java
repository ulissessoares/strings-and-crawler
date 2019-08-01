package idwall.desafio.string;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class IdwallFormatterParameterizedWithoutJustificationTest {

        String unwrappedText;
        String expectedWrappedText;
        Integer wrapLimit;
        Boolean justify;

        IdwallFormatter formatter;
        String wrappedText;




        public IdwallFormatterParameterizedWithoutJustificationTest(String unwrappedText, String expectedWrappedText, Integer wrapLimit, Boolean justify) {
                this.unwrappedText = unwrappedText;
                this.expectedWrappedText = expectedWrappedText;
                this.wrapLimit = wrapLimit;
                this.justify = justify;
        }

        @Parameterized.Parameters
        public static Collection wraperTextData() {
                return Arrays.asList(new Object[][] {
                        { IdwallFormatterParameterizedTestCases.UNWRAPPED_DEFAULT_TEXT, IdwallFormatterParameterizedTestCases.EXPECTED_WRAPPED_DEFAULT_TEXT, 40, false},
                        { IdwallFormatterParameterizedTestCases.UNWRAPPED_TEXT_CASE_ONE_LINE_LONGER_THAN_LIMIT_AND_SHORTER_THAN_2X_LIMIT, IdwallFormatterParameterizedTestCases.EXPECTED_WRAPPED_TEXT_CASE_ONE_LINE_LONGER_THAN_LIMIT_AND_SHORTER_THAN_2X_LIMIT, 40, false},
                        { IdwallFormatterParameterizedTestCases.UNWRAPPED_TEXT_CASE_ONE_LINE_SEVERAL_TIMES_LONGER_THAN_WRAP_LIMIT, IdwallFormatterParameterizedTestCases.EXPECTED_WRAPPED_TEXT_CASE_ONE_LINE_SEVERAL_TIMES_LONGER_THAN_WRAP_LIMIT, 40, false},
                        { IdwallFormatterParameterizedTestCases.UNWRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_LONGER_THAN_LIMIT, IdwallFormatterParameterizedTestCases.EXPECTED_WRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_LONGER_THAN_LIMIT, 40, false},
                        { IdwallFormatterParameterizedTestCases.UNWRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT, IdwallFormatterParameterizedTestCases.EXPECTED_WRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT, 40, false},
                        { IdwallFormatterParameterizedTestCases.UNWRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT_AND_BLANK_LINES, IdwallFormatterParameterizedTestCases.EXPECTED_WRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT_AND_BLANK_LINES, 40, false}
                });
        }

        @Before
        public void initialize() {
                formatter = new IdwallFormatter(wrapLimit, justify);
                wrappedText = formatter.format(unwrappedText);
        }

        @Test
        public void wrappedTextShouldHaveMoreLinesThanUnwrappedText() {
                TestUtils.wrappedTextShouldHaveMoreLinesThanUnwrappedText(wrappedText, unwrappedText);
        }

        @Test
        public void wrappedTextLinesShouldBeSmallerOrEqualThanLineLimit() {
                TestUtils.wrappedTextLinesShouldBeSmallerOrEqualThanLineLimit(wrappedText, wrapLimit);
        }

        @Test
        public void wrappedTextShouldHaveTheSameNumerOfBlankLinesThatOfTheUnwrappedText() {
                TestUtils.wrappedTextShouldHaveTheSameNumerOfBlankLinesThatOfTheUnwrappedText(wrappedText, unwrappedText);
        }

        @Test
        public void wrappedTextShouldHaveTheSameWordCountThatOfUnwrappedText() {
                TestUtils.wrappedTextShouldHaveTheSameWordCountThatOfUnwrappedText(wrappedText, unwrappedText);
        }

        @Test
        public void wrappedTextShouldBeEqualExpectedWrappedText() {
                System.out.println("Wrapped Text:");
                System.out.println(wrappedText);
                System.out.println("Expected Wrapped Text:");
                System.out.println(expectedWrappedText);

                assert expectedWrappedText.equals(wrappedText);
        }




}


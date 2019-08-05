package idwall.desafio.string;

public class IdwallFormatterParameterizedTestCases {


    public static final String TEST_CASE_1_DESCRIPTION = "Format without justify one blank line must result in one blank line";
    public static final Boolean TEST_CASE_1_JUSTIFY = false;
    public static final Integer TEST_CASE_1_LINE_LIMIT = 40;
    public static final String TEST_CASE_1_INPUT_DATA = "";
    public static final String TEST_CASE_1_EXPECTED_RESULT = "";

    public static final String TEST_CASE_2_DESCRIPTION = "Format without justify several blank lines must result in several blank lines";
    public static final Boolean TEST_CASE_2_JUSTIFY = false;
    public static final Integer TEST_CASE_2_LINE_LIMIT = 40;
    public static final String TEST_CASE_2_INPUT_DATA = "\n\n";
    public static final String TEST_CASE_2_EXPECTED_RESULT = "\r\n\r\n";

    public static final String TEST_CASE_3_DESCRIPTION = "Format without justify one line equals the limit must result in the same line";
    public static final Boolean TEST_CASE_3_JUSTIFY = false;
    public static final Integer TEST_CASE_3_LINE_LIMIT = 40;
    public static final String TEST_CASE_3_INPUT_DATA = "This is a example of text";
    public static final String TEST_CASE_3_EXPECTED_RESULT = "This is a example of text";

    public static final String TEST_CASE_4_DESCRIPTION = "Format without justify text ending with blank line must preserve the blank line at the end ";
    public static final Boolean TEST_CASE_4_JUSTIFY = false;
    public static final Integer TEST_CASE_4_LINE_LIMIT = 40;
    public static final String TEST_CASE_4_INPUT_DATA = "Text with blank line at the end\n";
    public static final String TEST_CASE_4_EXPECTED_RESULT = "Text with blank line at the end\r\n";

    public static final String TEST_CASE_5_DESCRIPTION = "Format without justify text beginning with blank line must preserve the blank line at the begin ";
    public static final Boolean TEST_CASE_5_JUSTIFY = false;
    public static final Integer TEST_CASE_5_LINE_LIMIT = 40;
    public static final String TEST_CASE_5_INPUT_DATA = "\nText with blank line at the begin";
    public static final String TEST_CASE_5_EXPECTED_RESULT = "\r\nText with blank line at the begin";

    public static final String TEST_CASE_6_DESCRIPTION = "Format without justify one line smaller than limit must result in the same line ";
    public static final Boolean TEST_CASE_6_JUSTIFY = false;
    public static final Integer TEST_CASE_6_LINE_LIMIT = 40;
    public static final String TEST_CASE_6_INPUT_DATA = "Text samller than limit";
    public static final String TEST_CASE_6_EXPECTED_RESULT = "Text samller than limit";

    public static final String TEST_CASE_7_DESCRIPTION = "Format without justify one line bigger than the limit and smaller than (limit x2) must result in two lines";
    public static final Boolean TEST_CASE_7_JUSTIFY = false;
    public static final Integer TEST_CASE_7_LINE_LIMIT = 40;
    public static final String TEST_CASE_7_INPUT_DATA = "One big line that is bigger than the limit but not bigger than 2x the limit";
    public static final String TEST_CASE_7_EXPECTED_RESULT = "One big line that is bigger than the\r\n" +
            "limit but not bigger than 2x the limit";


    public static final String TEST_CASE_8_DESCRIPTION = "Format without justify one very big line must result in output text with several lines";
    public static final Boolean TEST_CASE_8_JUSTIFY = false;
    public static final Integer TEST_CASE_8_LINE_LIMIT = 40;
    public static final String TEST_CASE_8_INPUT_DATA = "This is one very big line that is several times the wrap limit defined for this text case, which is 40 characters of length by the way.";
    public static final String TEST_CASE_8_EXPECTED_RESULT = "This is one very big line that is\r\n" +
            "several times the wrap limit defined for\r\n" +
            "this text case, which is 40 characters\r\n" +
            "of length by the way.";

    public static final String TEST_CASE_9_DESCRIPTION = "Format without justify text with several lines, all lines longer than the limit";
    public static final Boolean TEST_CASE_9_JUSTIFY = false;
    public static final Integer TEST_CASE_9_LINE_LIMIT = 40;
    public static final String TEST_CASE_9_INPUT_DATA = "This is a very long text, made that all lines are longer than 40 char.\r\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\r\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\r\n" +
            "So I used it for generating my inputs and outputs.";
    public static final String TEST_CASE_9_EXPECTED_RESULT = "This is a very long text, made that all\r\n" +
            "lines are longer than 40 char. All of\r\n" +
            "this was possible using the Visual\r\n" +
            "Studio Code Rewrap extension. Rewrap\r\n" +
            "extension format text for the exact same\r\n" +
            "result of this formatter code challente.\r\n" +
            "So I used it for generating my inputs\r\n" +
            "and outputs.";

    public static final String TEST_CASE_10_DESCRIPTION = "Format without justify text with several lines, some longer than the limit and some shorter or same size than the limit";
    public static final Boolean TEST_CASE_10_JUSTIFY = false;
    public static final Integer TEST_CASE_10_LINE_LIMIT = 40;
    public static final String TEST_CASE_10_INPUT_DATA = "This is a very long text, made that with lines are longer than 40 char.\n" +
            "And some lines shorter than 40 chars.\n" +
            "Like this line.\n" +
            "And this line too.\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\n" +
            "So I used it for generating my inputs and outputs.";
    public static final String TEST_CASE_10_EXPECTED_RESULT = "This is a very long text, made that with\r\n" +
            "lines are longer than 40 char. And some\r\n" +
            "lines shorter than 40 chars. Like this\r\n" +
            "line. And this line too.\r\n" +
            "All of this was possible using the\r\n" +
            "Visual Studio Code Rewrap extension.\r\n" +
            "Rewrap extension format text for the\r\n" +
            "exact same result of this formatter code\r\n" +
            "challente. So I used it for generating\r\n" +
            "my inputs and outputs.";

    public static final String TEST_CASE_11_DESCRIPTION = "Format without justify text with several lines, some longer than the limit, some shorter, some same size than the limit and some blank";
    public static final Boolean TEST_CASE_11_JUSTIFY = false;
    public static final Integer TEST_CASE_11_LINE_LIMIT = 40;
    public static final String TEST_CASE_11_INPUT_DATA = "This is a very long text, made that with lines are longer than 40 char.\n" +
            "And some lines shorter than 40 chars.\n" +
            "Like this line.\n" +
            "And this line too.\n" +
            "\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\n" +
            "\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\n" +
            "\n" +
            "\n" +
            "So I used it for generating my inputs and outputs.";
    public static final String TEST_CASE_11_EXPECTED_RESULT = "This is a very long text, made that with\r\n" +
            "lines are longer than 40 char. And some\r\n" +
            "lines shorter than 40 chars. Like this\r\n" +
            "line. And this line too.\r\n" +
            "\r\n" +
            "All of this was possible using the\r\n" +
            "Visual Studio Code Rewrap extension.\r\n" +
            "\r\n" +
            "Rewrap extension format text for the\r\n" +
            "exact same result of this formatter code\r\n" +
            "challente.\r\n" +
            "\r\n" +
            "\r\n" +
            "So I used it for generating my inputs\r\n" +
            "and outputs.";

    public static final String TEST_CASE_12_DESCRIPTION = "Format without justify example text of the challenge";
    public static final Boolean TEST_CASE_12_JUSTIFY = false;
    public static final Integer TEST_CASE_12_LINE_LIMIT = 40;
    public static final String TEST_CASE_12_INPUT_DATA = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";;
    public static final String TEST_CASE_12_EXPECTED_RESULT = "In the beginning God created the heavens\r\n" +
            "and the earth. Now the earth was\r\n" +
            "formless and empty, darkness was over\r\n" +
            "the surface of the deep, and the Spirit\r\n" +
            "of God was hovering over the waters.\r\n" +
            "\r\n" +
            "And God said, \"Let there be light,\" and\r\n" +
            "there was light. God saw that the light\r\n" +
            "was good, and he separated the light\r\n" +
            "from the darkness. God called the light\r\n" +
            "\"day,\" and the darkness he called\r\n" +
            "\"night.\" And there was evening, and\r\n" +
            "there was morning - the first day.";


    public static final String TEST_CASE_13_DESCRIPTION = "Format with justify one blank line must result in one blank line";
    public static final Boolean TEST_CASE_13_JUSTIFY = true;
    public static final Integer TEST_CASE_13_LINE_LIMIT = 40;
    public static final String TEST_CASE_13_INPUT_DATA = "";
    public static final String TEST_CASE_13_EXPECTED_RESULT = "";

    public static final String TEST_CASE_14_DESCRIPTION = "Format with justify several blank lines must result in several blank lines";
    public static final Boolean TEST_CASE_14_JUSTIFY = true;
    public static final Integer TEST_CASE_14_LINE_LIMIT = 40;
    public static final String TEST_CASE_14_INPUT_DATA = "\n\n";
    public static final String TEST_CASE_14_EXPECTED_RESULT = "\r\n\r\n";

    public static final String TEST_CASE_15_DESCRIPTION = "Format with justify one line equals the limit must result in the same line";
    public static final Boolean TEST_CASE_15_JUSTIFY = true;
    public static final Integer TEST_CASE_15_LINE_LIMIT = 40;
    public static final String TEST_CASE_15_INPUT_DATA = "In the beginning God created the heavens";
    public static final String TEST_CASE_15_EXPECTED_RESULT = "In the beginning God created the heavens";

    public static final String TEST_CASE_16_DESCRIPTION = "Format with justify ending with blank line must preserve the blank line at the end ";
    public static final Boolean TEST_CASE_16_JUSTIFY = true;
    public static final Integer TEST_CASE_16_LINE_LIMIT = 40;
    public static final String TEST_CASE_16_INPUT_DATA = "Text with blank line at the end\n";
    public static final String TEST_CASE_16_EXPECTED_RESULT = "Text   with  blank   line  at   the  end\r\n";

    public static final String TEST_CASE_17_DESCRIPTION = "Format with justify text beginning with blank line must preserve the blank line at the begin ";
    public static final Boolean TEST_CASE_17_JUSTIFY = true;
    public static final Integer TEST_CASE_17_LINE_LIMIT = 40;
    public static final String TEST_CASE_17_INPUT_DATA = "\nText with blank line at the begin";
    public static final String TEST_CASE_17_EXPECTED_RESULT = "\r\nText   with  blank  line  at  the  begin";

    public static final String TEST_CASE_18_DESCRIPTION = "Format with justify one line smaller than limit must result in justified line ";
    public static final Boolean TEST_CASE_18_JUSTIFY = true;
    public static final Integer TEST_CASE_18_LINE_LIMIT = 40;
    public static final String TEST_CASE_18_INPUT_DATA = "Text smaller than limit";
    public static final String TEST_CASE_18_EXPECTED_RESULT = "Text       smaller      than       limit";

    public static final String TEST_CASE_19_DESCRIPTION = "Format with justify one line bigger than the limit and smaller than (limit x2) must result in two lines with length smaller or equals to the limit and input and output texts must have the same word count ";
    public static final Boolean TEST_CASE_19_JUSTIFY = true;
    public static final Integer TEST_CASE_19_LINE_LIMIT = 40;
    public static final String TEST_CASE_19_INPUT_DATA = "One big line that is bigger than the limit but not bigger than 2x the limit";
    public static final String TEST_CASE_19_EXPECTED_RESULT = "One  big line  that is  bigger than  the\r\n" +
            "limit  but not  bigger than 2x the limit";

    public static final String TEST_CASE_20_DESCRIPTION = "Format with justify one very big line must result in output text with several lines, lines length must be smaller or equal than the limit and input and ouput text must have the same word count ";
    public static final Boolean TEST_CASE_20_JUSTIFY = true;
    public static final Integer TEST_CASE_20_LINE_LIMIT = 40;
    public static final String TEST_CASE_20_INPUT_DATA = "This is one very big line that is several times the wrap limit defined for this text case, which is 40 characters of length by the way.";
    public static final String TEST_CASE_20_EXPECTED_RESULT = "This  is  one  very  big  line  that  is\r\n" +
            "several times the wrap limit defined for\r\n" +
            "this  text case,  which is 40 characters\r\n" +
            "of      length     by      the      way.";

    public static final String TEST_CASE_21_DESCRIPTION = "Format with justify text with several lines all bigger than the limit must result in an output text with bigger line count, lines with length smaller or equal than the limit and input and output texts must have the same word count ";
    public static final Boolean TEST_CASE_21_JUSTIFY = true;
    public static final Integer TEST_CASE_21_LINE_LIMIT = 40;
    public static final String TEST_CASE_21_INPUT_DATA = "This is a very long text, made that all lines are longer than 40 char.\r\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\r\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\r\n" +
            "So I used it for generating my inputs and outputs.";
    public static final String TEST_CASE_21_EXPECTED_RESULT = "This  is a very long text, made that all\r\n" +
            "lines  are longer  than 40  char. All of\r\n" +
            "this   was  possible  using  the  Visual\r\n" +
            "Studio  Code  Rewrap  extension.  Rewrap\r\n" +
            "extension format text for the exact same\r\n" +
            "result of this formatter code challente.\r\n" +
            "So  I used  it for  generating my inputs\r\n" +
            "and                             outputs.";

    public static final String TEST_CASE_22_DESCRIPTION = "Format with justify text with several lines, some longer than the limit and some shorter or same size than the limit must result in an output text with more lines than the input text, all lines must be have length smaller or equal and than the  limit and input and output text must have the same word count";
    public static final Boolean TEST_CASE_22_JUSTIFY = true;
    public static final Integer TEST_CASE_22_LINE_LIMIT = 40;
    public static final String TEST_CASE_22_INPUT_DATA = "This is a very long text, made that with lines are longer than 40 char.\n" +
            "And some lines shorter than 40 chars.\n" +
            "Like this line.\n" +
            "And this line too.\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\n" +
            "So I used it for generating my inputs and outputs.";
    public static final String TEST_CASE_22_EXPECTED_RESULT = "This is a very long text, made that with\r\n" +
            "lines  are longer than 40 char. And some\r\n" +
            "lines  shorter than  40 chars. Like this\r\n" +
            "line.     And     this     line     too.\r\n" +
            "All  of  this  was  possible  using  the\r\n" +
            "Visual  Studio  Code  Rewrap  extension.\r\n" +
            "Rewrap  extension format  text  for  the\r\n" +
            "exact same result of this formatter code\r\n" +
            "challente.  So I  used it for generating\r\n" +
            "my       inputs       and       outputs.";

    public static final String TEST_CASE_23_DESCRIPTION = "Format with justify text with several lines, some longer than the limit, some shorter, some same size than the limit and some blank must result in an output text with more lines than the input text, all lines must be have length smaller or equal  and than the limit and input and output text must have the same word count";
    public static final Boolean TEST_CASE_23_JUSTIFY = true;
    public static final Integer TEST_CASE_23_LINE_LIMIT = 40;
    public static final String TEST_CASE_23_INPUT_DATA = "This is a very long text, made that with lines are longer than 40 char.\n" +
            "And some lines shorter than 40 chars.\n" +
            "Like this line.\n" +
            "And this line too.\n" +
            "\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\n" +
            "\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\n" +
            "\n" +
            "\n" +
            "So I used it for generating my inputs and outputs.";
    public static final String TEST_CASE_23_EXPECTED_RESULT = "This is a very long text, made that with\r\n" +
            "lines  are longer than 40 char. And some\r\n" +
            "lines  shorter than  40 chars. Like this\r\n" +
            "line.     And     this     line     too.\r\n" +
            "\r\n" +
            "All  of  this  was  possible  using  the\r\n" +
            "Visual  Studio  Code  Rewrap  extension.\r\n" +
            "\r\n" +
            "Rewrap  extension format  text  for  the\r\n" +
            "exact same result of this formatter code\r\n" +
            "               challente.               \r\n" +
            "\r\n" +
            "\r\n" +
            "So  I used  it for  generating my inputs\r\n" +
            "and                             outputs.";

    public static final String TEST_CASE_24_DESCRIPTION = "Format with justify example text of the challenge";
    public static final Boolean TEST_CASE_24_JUSTIFY = true;
    public static final Integer TEST_CASE_24_LINE_LIMIT = 40;
    public static final String TEST_CASE_24_INPUT_DATA = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";;
    public static final String TEST_CASE_24_EXPECTED_RESULT = "In the beginning God created the heavens\r\n" +
            "and   the  earth.   Now  the  earth  was\r\n" +
            "formless  and empty,  darkness was  over\r\n" +
            "the  surface of the deep, and the Spirit\r\n" +
            "of  God was  hovering over  the  waters.\r\n" +
            "\r\n" +
            "And  God said, \"Let there be light,\" and\r\n" +
            "there  was light. God saw that the light\r\n" +
            "was  good, and  he separated  the  light\r\n" +
            "from  the darkness. God called the light\r\n" +
            "\"day,\"   and  the   darkness  he  called\r\n" +
            "\"night.\"  And  there  was  evening,  and\r\n" +
            "there  was  morning  -  the  first  day.";



}

package idwall.desafio.string;

public class IdwallFormatterParameterizedTestCases {

    public static final String UNWRAPPED_DEFAULT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

    public static final String EXPECTED_WRAPPED_DEFAULT_TEXT = "In the beginning God created the heavens\r\n" +
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




    public static final String UNWRAPPED_TEXT_CASE_ONE_LINE_LONGER_THAN_LIMIT_AND_SHORTER_THAN_2X_LIMIT = "One big line that is bigger than the limit but not bigger than 2x the limit";
    public static final String EXPECTED_WRAPPED_TEXT_CASE_ONE_LINE_LONGER_THAN_LIMIT_AND_SHORTER_THAN_2X_LIMIT = "One big line that is bigger than the\r\n" +
            "limit but not bigger than 2x the limit";



    public static final String UNWRAPPED_TEXT_CASE_ONE_LINE_SEVERAL_TIMES_LONGER_THAN_WRAP_LIMIT = "This is one very big line that is several times the wrap limit definid for this text case, which is 40 characters of length by the way.";
    public static final String EXPECTED_WRAPPED_TEXT_CASE_ONE_LINE_SEVERAL_TIMES_LONGER_THAN_WRAP_LIMIT = "This is one very big line that is\r\n" +
            "several times the wrap limit definid for\r\n" +
            "this text case, which is 40 characters\r\n" +
            "of length by the way.";



    public static final String UNWRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_LONGER_THAN_LIMIT = "This is a very long text, made that all lines are longer than 40 char.\r\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\r\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\r\n" +
            "So I used it for generating my inputs and outputs.";

    public static final String EXPECTED_WRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_LONGER_THAN_LIMIT = "This is a very long text, made that all\r\n" +
            "lines are longer than 40 char. All of\r\n" +
            "this was possible using the Visual\r\n" +
            "Studio Code Rewrap extension. Rewrap\r\n" +
            "extension format text for the exact same\r\n" +
            "result of this formatter code challente.\r\n" +
            "So I used it for generating my inputs\r\n" +
            "and outputs.";




    public static final String UNWRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT = "This is a very long text, made that with lines are longer than 40 char.\n" +
            "And some lines shorter than 40 chars.\n" +
            "Like this line.\n" +
            "And this line too.\n" +
            "All of this was possible using the Visual Studio Code Rewrap extension.\n" +
            "Rewrap extension format text for the exact same result of this formatter code challente.\n" +
            "So I used it for generating my inputs and outputs.";

    public static final String EXPECTED_WRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT = "This is a very long text, made that with\r\n" +
            "lines are longer than 40 char. And some\r\n" +
            "lines shorter than 40 chars. Like this\r\n" +
            "line. And this line too.\r\n" +
            "All of this was possible using the\r\n" +
            "Visual Studio Code Rewrap extension.\r\n" +
            "Rewrap extension format text for the\r\n" +
            "exact same result of this formatter code\r\n" +
            "challente. So I used it for generating\r\n" +
            "my inputs and outputs.";


    public static final String UNWRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT_AND_BLANK_LINES = "This is a very long text, made that with lines are longer than 40 char.\n" +
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

    public static final String EXPECTED_WRAPPED_TEXT_CASE_TEXT_WITH_SEVERAL_LINES_WITH_LINES_LONGER_AND_SHORTER_THAN_THE_LIMIT_AND_BLANK_LINES = "This is a very long text, made that with\r\n" +
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


}

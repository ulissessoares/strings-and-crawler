package idwall.desafio.string;

import java.util.*;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

    private Boolean justify;
    private StringJustifier justifier;

    public IdwallFormatter(Integer limit, Boolean justify) {
        super();
        this.limit = limit;
        this.justify = justify;
        this.justifier = new IdwallJustifier(limit);

    }

    /**
     * Should format as described in the challenge
     *
     * @param text
     * @return
     */
    @Override
    public String format(String text) {
        Stack<String> inputLines = parseInputLinesStack(text);
        List<String> outputLines = new ArrayList<>();


        while (inputLines.size() > 0) {
            String line = inputLines.pop();
            String formattedLine = line;

            if(line.length() > limit) {

                Integer wrapIndex = calculateWrapIndex(line, limit);

                formattedLine = line.substring(0, wrapIndex);

                String tail = line.substring(wrapIndex);
                tail = tail.trim();
                String nextLine = "";

                if(inputLines.size() != 0) {
                    nextLine = inputLines.pop();
                    if (nextLine.equals(""))
                        inputLines.push(nextLine);
                }

                nextLine =  tail + " " + nextLine;
                nextLine = nextLine.trim();
                inputLines.push(nextLine);

            }

            if(justify && !formattedLine.equals(""))
                formattedLine = justifier.justify(formattedLine);

            outputLines.add(formattedLine);

        }

        return consolidateText(outputLines);
    }

    protected Stack<String> parseInputLinesStack(String text) {

        Stack<String> stack = new Stack<>();
        List<String> inputLines = new ArrayList<>();
        inputLines.addAll(Arrays.asList(text.split("\\r?\\n", -1)));

        Collections.reverse(inputLines);
        stack.addAll(inputLines);
        return stack;
    }

    protected Integer calculateWrapIndex(String line, Integer limit) {
        if (String.valueOf(line.charAt(limit)).equals(" "))
            return limit;

        String trunkedLine = line.substring(0, limit);
        return trunkedLine.lastIndexOf(" ");
    }

    protected String consolidateText(List<String> lines) {
        return String.join("\r\n", lines);
    }
}

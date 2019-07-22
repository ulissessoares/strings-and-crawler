package idwall.desafio.string;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

    private Boolean justify;

    public IdwallFormatter(Integer limit, Boolean justify) {
        super();
        this.limit = limit;
        this.justify = justify;

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

                Integer cuttingIndex = calculateCuttingIndex(line, limit);

                formattedLine = line.substring(0, cuttingIndex);

                String tail = line.substring(cuttingIndex);
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

            if(justify)
                formattedLine = justifyLine(formattedLine, limit);

            outputLines.add(formattedLine);
//            System.out.println("Output:");
//            for(String outLine : outputLines) {
//                System.out.println(outLine);
//            }
//            System.out.println();

        }

        return consolidateText(outputLines);
    }

    protected Stack<String> parseInputLinesStack(String text) {

        Stack<String> stack = new Stack<>();
        List<String> inputLines = new ArrayList<>();
        inputLines.addAll(Arrays.asList(text.split("\\r?\\n")));

        if(String.valueOf(text.charAt(text.length() - 1)).matches("\\r?\\n"))
            inputLines.add("");

        Collections.reverse(inputLines);
        stack.addAll(inputLines);
        return stack;
    }

    //TODO
    protected String justifyLine(String line, Integer limit) {
        return line;
    }

    //TODO
    protected Integer calculateCuttingIndex(String line, Integer limit) {
        if (String.valueOf(line.charAt(limit)).equals(" "))
            return limit;

        String trunkedLine = line.substring(0, limit);
        return trunkedLine.lastIndexOf(" ");
    }

    //TODO
    protected String consolidateText(List<String> lines) {
        return String.join("\r\n", lines);
    }
}

package idwall.desafio.string;

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
        Queue<String> inputLines = parseInputLinesQueue(text);
        List<String> outputLines = new ArrayList<>();


        while (inputLines.size() > 0) {
            String line = inputLines.poll();

            if(line.length() > limit) {

                Integer cuttingIndex = limit;
                if (!String.valueOf(line.charAt(limit + 1)).equals(" "))
                    cuttingIndex = calculateCuttingIndex(line, limit);

                line = line.substring(0, cuttingIndex);
                String tail = line.substring(cuttingIndex);
                String nextLine = inputLines.poll();
                nextLine =  tail + " " + nextLine;
                inputLines.add(nextLine);

            }

            if(justify)
                line = justifyLine(line, limit);

            outputLines.add(line);

        }

        return consolidateText(outputLines);
    }

    private Queue<String> parseInputLinesQueue(String text) {

        Queue<String> queue = new LinkedList<>();
        List<String> inputLines = Arrays.asList(text.split("\\r?\\n"));
        Collections.reverse(inputLines);
        queue.addAll(inputLines);
        return queue;
    }

    //TODO
    private String justifyLine(String line, Integer limit) {
        return line;
    }

    //TODO
    private Integer calculateCuttingIndex(String line, Integer limit) {
        return limit;
    }

    //TODO
    private String consolidateText(List<String> lines) {
        return String.join("\\r\\n", lines);
    }
}

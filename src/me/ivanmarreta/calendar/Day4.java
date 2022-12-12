package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Day4 {

    public static void main(String[] args) throws IOException {

        String input = """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8
                """;

        int fullyContain = 0;

        String fileName = "inputs/day4.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> lines = stream.toList();
//            String[] lines = input.split("\n");
            for (String line : lines) {
                final String[] pairs = line.split(",");

                final String[] pair1 = pairs[0].split("-");
                final String[] pair2 = pairs[1].split("-");

                final int pair1StartSession = Integer.parseInt(pair1[0]);
                final int pair1EndSession = Integer.parseInt(pair1[1]);

                final int pair2StartSession = Integer.parseInt(pair2[0]);
                final int pair2EndSession = Integer.parseInt(pair2[1]);

                if (pair1StartSession <= pair2StartSession && pair1EndSession >= pair2EndSession
                    || pair1StartSession >= pair2StartSession && pair1EndSession <= pair2EndSession) {
                    fullyContain++;
                }

            }

            //PART 1
            System.out.println(fullyContain);
        }
    }
}

package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Day4 {

    public static void main(String[] args) throws IOException {

        int fullyContain = 0;
        int noRangesOverlaps = 0;

        String fileName = "inputs/day4.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> lines = stream.toList();
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

                if (pair1StartSession > pair2EndSession
                    || pair2StartSession > pair1EndSession) {
                    noRangesOverlaps++;
                }

            }

            //PART 1
            System.out.println(fullyContain);

            //PART 2
            int rangesOverlap = lines.size() - noRangesOverlaps;
            System.out.println(rangesOverlap);
        }
    }
}

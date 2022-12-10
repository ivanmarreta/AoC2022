package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Day2 {

    public static void main(String[] args) throws IOException {

        final int ROCK     = 1;
        final int PAPER    = 2;
        final int SCISSORS = 3;

        final int LOSS = 0;
        final int DRAW = 3;
        final int WIN  = 6;

        Map<String, Integer[]> strategy = new HashMap<>();
        strategy.put("A X", new Integer[] {ROCK + DRAW, 3});
        strategy.put("A Y", new Integer[] {PAPER + WIN, 4});
        strategy.put("A Z", new Integer[] {SCISSORS + LOSS, 8});
        strategy.put("B X", new Integer[] {ROCK + LOSS, 1});
        strategy.put("B Y", new Integer[] {PAPER + DRAW, 5});
        strategy.put("B Z", new Integer[] {SCISSORS + WIN, 9});
        strategy.put("C X", new Integer[] {ROCK + WIN, 2});
        strategy.put("C Y", new Integer[] {PAPER + LOSS, 6});
        strategy.put("C Z", new Integer[] {SCISSORS + DRAW, 7});

        String fileName = "inputs/day2.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            int part1 = 0;
            int part2 = 0;

            for (String line : stream.toList()) {
                Integer[] scores = strategy.get(line.strip());
                part1 += scores[0];
                part2 += scores[1];
            }

            //PART 1
            System.out.println(part1);

            //PART 2
            System.out.println(part2);
        }
    }
}

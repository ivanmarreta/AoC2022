package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Day2 {

    public static void main(String[] args) throws IOException {
        String fileName = "inputs/day2.txt";

        String inputs = """
                A Y
                B X
                C Z
                """;

        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;

        final int LOSS = 0;
        final int DRAW = 3;
        final int WIN = 6;

        Map<String, Integer> strategy = new HashMap<>();
        strategy.put("A X", ROCK + DRAW);
        strategy.put("A Y", PAPER + WIN);
        strategy.put("A Z", SCISSORS + LOSS);
        strategy.put("B X", ROCK + LOSS);
        strategy.put("B Y", PAPER + DRAW);
        strategy.put("B Z", SCISSORS + WIN);
        strategy.put("C X", ROCK + WIN);
        strategy.put("C Y", PAPER + LOSS);
        strategy.put("C Z", SCISSORS + DRAW);

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            int score = 0;
            for (String line : stream.toList()) {
                score += strategy.get(line.strip());
            }

            //PART 1
            System.out.println(score);
        }
    }
}

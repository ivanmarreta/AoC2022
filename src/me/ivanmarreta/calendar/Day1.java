package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args) throws IOException{

        String fileName = "inputs/day1.txt";

        List<Integer> totalCalories = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            int caloriesByElf = 0;
            for (String line : stream.toList()) {
                if (line.isBlank()) {
                    totalCalories.add(caloriesByElf);
                    caloriesByElf = 0;
                    continue;
                }
                caloriesByElf += Integer.parseInt(line.strip());
            }
        }
        
        Integer part1Result = Collections.max(totalCalories);
        System.out.println(part1Result);

        totalCalories.sort(Collections.reverseOrder());

        int part2Result = totalCalories.stream()
                .limit(3)
                .reduce(0, Integer::sum);
        System.out.println(part2Result);
    }

}
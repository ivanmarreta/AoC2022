package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Day3 {

    public static void main(String[] args) throws IOException {

        String input = """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
                """;

        final String[] charactersOrdered = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        LinkedList<String> linkedList = new LinkedList<String>();
        Collections.addAll(linkedList, charactersOrdered);

        int part1 = 0;

        String fileName = "inputs/day3.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            for (String line : stream.toList()) {
//            for (String line : input.split("\n")) {
                int[] lineCharValues = new int[line.length()];
                String[] lineChars = line.split("");
                for (int i = 0; i < lineChars.length; i++) {
                    lineCharValues[i] = linkedList.indexOf(lineChars[i]);
                }

                int half = line.length() / 2;
                int[] compartmentOne = Arrays.copyOfRange(lineCharValues, 0, half);
                int[] compartmentTwo = Arrays.copyOfRange(lineCharValues, half, lineCharValues.length);

                Set<Integer> duplicates = new HashSet<>();
                for (int k = 0; k < compartmentOne.length; k++) {
                    for (int j = 0; j < compartmentTwo.length; j++) {
                        if (compartmentOne[k] == compartmentTwo[j]) {
                            duplicates.add(compartmentOne[k]);
                        }
                    }
                }
                part1 += duplicates.stream().reduce(Integer::sum).get();
            }
        }

        System.out.println(part1);
    }
}

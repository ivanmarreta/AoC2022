package me.ivanmarreta.calendar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

    public static void main(String[] args) throws IOException {

        final String[] charactersOrdered = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        LinkedList<String> charactersOrderedList = new LinkedList<>();
        Collections.addAll(charactersOrderedList, charactersOrdered);

        int part1Result = 0;
        int part2Result = 0;

        String fileName = "inputs/day3.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> lines = stream.toList();
            LinkedList<int[]> lineCharacterList = new LinkedList<>();

            for (String line : lines) {
                int[] lineCharValues = new int[line.length()];
                String[] lineChars = line.split("");
                for (int i = 0; i < lineChars.length; i++) {
                    lineCharValues[i] = charactersOrderedList.indexOf(lineChars[i]);
                }

                lineCharacterList.add(lineCharValues);

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
                part1Result += duplicates.stream().reduce(Integer::sum).get();
            }

            System.out.println(part1Result);

            final AtomicInteger counter = new AtomicInteger();
            List<List<int[]>> listPartition =
                    lineCharacterList.stream()
                            .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 3))
                            .values().stream().toList();

            for (List<int[]> partition : listPartition) {
                int[] lineOne = partition.get(0);
                int[] lineTwo = partition.get(1);
                int[] lineThree = partition.get(2);

                Set<Integer> duplicates = new HashSet<>();
                for (int k = 0; k < lineOne.length; k++) {
                    for (int j = 0; j < lineTwo.length; j++) {
                        for (int t = 0; t < lineThree.length; t++) {
                            if (lineOne[k] == lineTwo[j] && lineTwo[j] == lineThree[t]) {
                                duplicates.add(lineOne[k]);
                            }
                        }
                    }
                }
                part2Result += duplicates.stream().reduce(Integer::sum).get();
            }

            System.out.println(part2Result);
        }
    }
}

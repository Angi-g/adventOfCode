package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.lines(Paths.get("src/main/resources/input.txt")).toList();
        int countSafeLine = 0;
        for (String line : lines) {

            int[] parsedInt = parseStrLineToArrayInt(line);
            if (isLineSafe(parsedInt)) {
                countSafeLine++;
            } else {
                boolean isOneSafe = false;
                for (int i = 0; i < parsedInt.length; i++) {
                    if (isLineSafeWithOneValueIgnored(parsedInt, i)) {
                        isOneSafe = true;
                        break;
                    }
                }
                if (isOneSafe) {
                    countSafeLine++;
                }
            }
        }
        System.out.println("number of safe lines: " + countSafeLine);
    }

    public static boolean isSpaceValid(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            int space = Math.abs(line[i] - line[i + 1]);

            if (space < 1 || space > 3) {
                return false;
            }
        }
        return true;
    }

    public static int[] parseStrLineToArrayInt(String input) {
        String[] inputArray = input.split(" ");
        int[] arr = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }
        return arr;
    }

    public static boolean isAlwaysIncrease(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlwaysDecrease(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] < input[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLineSafe(int[] line) {
        if (!isSpaceValid(line))
            return false;
        if (line[0] > line[1]) {
            return isAlwaysDecrease(line);
        } else {
            return isAlwaysIncrease(line);
        }
    }

    public static boolean isLineSafeWithOneValueIgnored(int[] line, int ignored) {

        // Création d'une nouvelle liste en ignorant l'index `ignored`
        int[] modifiedLine = new int[line.length - 1];
        int idx = 0;
        for (int i = 0; i < line.length; i++) {
            if (i != ignored) {
                modifiedLine[idx++] = line[i];
            }
        }

        return isSpaceValid(modifiedLine) && (isAlwaysIncrease(modifiedLine) || isAlwaysDecrease(modifiedLine));

    }
}
package com.company.managers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderHelper {

    public List<List<Double>> readDoublesFromFile(String filePathToGraphMatrix) {
        filePathToGraphMatrix = filePathToGraphMatrix.replace("\\", "/");
        List<String> lines = readTextFromFile(filePathToGraphMatrix);
        return normalizeInput(lines);
    }

    private List<String> readTextFromFile(String filePath)
    {
        List<String> inputData = null;
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            inputData = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }

    private static List<Double> mapStringToDobule(String row) {
        return Arrays.stream(row.split("\\s")).map(number -> Double.parseDouble(number)).collect(Collectors.toList());
    }

    private static List<List<Double>> normalizeInput(List<String> rows) {
        return rows.stream().map(row -> mapStringToDobule(row)).collect(Collectors.toList());
    }

    public List<String> readAlphaFromFile(String filePathToAlpha) {
        filePathToAlpha = filePathToAlpha.replace("\\", "/");
        return readTextFromFile(filePathToAlpha);
    }

    public List<String> readBetaFromFile(String filePathToBeta) {
        filePathToBeta = filePathToBeta.replace("\\", "/");
        return readTextFromFile(filePathToBeta);
    }

    public List<String> readSFromFile(String filePathToS) {
        filePathToS = filePathToS.replace("\\", "/");
        return readTextFromFile(filePathToS);
    }
}

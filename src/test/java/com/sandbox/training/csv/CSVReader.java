package com.sandbox.training.csv;

import com.sandbox.training.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSVReader {

    private CSVFile csvFile = new CSVFile();
    private Map<String, String> parameters = new LinkedHashMap<>();

    public Map<String, String> read(String filePath) throws IOException {

        FileReader csvFileReader = FileUtils.getFileFromResources(filePath);

        try (BufferedReader csvReader = new BufferedReader(csvFileReader)) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                csvFile.read(line, parameters);
            }
        }
        return parameters;
    }
}
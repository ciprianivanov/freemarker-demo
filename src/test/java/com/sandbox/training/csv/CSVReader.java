package com.sandbox.training.csv;

import com.sandbox.training.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {

    private CSVFile csvFile = new CSVFile();
    private Map<String, List<String>> parameters = new LinkedHashMap<>();

    private Map<String, List<String>> read(String filePath) throws IOException {

        FileReader csvFileReader = FileUtils.getFileFromResources(filePath);

        try (BufferedReader csvReader = new BufferedReader(csvFileReader)) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                csvFile.read(line, parameters);
            }
        }
        return parameters;
    }

    private Map<String, String> getRowWithFilter(String filter) {

        LinkedHashMap filteredRow = new LinkedHashMap();
        List<String> names = parameters.get("name");
        int rowNumber = 0;

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(filter)) {
                rowNumber = i;
            }
        }

        for (Map.Entry entry : parameters.entrySet()) {
            filteredRow.put(entry.getKey(), ((List) entry.getValue()).get(rowNumber));
        }
        return filteredRow;
    }

    public Map<String, String> getTestData(String filePath, String filter) throws IOException {
        read(filePath);

        return getRowWithFilter(filter);
    }
}
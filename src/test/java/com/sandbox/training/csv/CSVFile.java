package com.sandbox.training.csv;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class CSVFile {

    private final String CSV_SEPARATOR = ",";

    private boolean headerRow = true;
    private List<String> headers; //TODO: Create an CSVRow object to hold the rows and for easier filtering of rows
    private List<String> rows;

    public void read(String line, Map<String, List<String>> parameters) {
        if (headerRow) {
            readHeaders(line, parameters);
        } else {
            readRows(line, parameters);
        }
    }

    public void readHeaders(String line, Map<String, List<String>> parameters) {
        headers = (asList(line.split(CSV_SEPARATOR)));
        for (int i = 0; i < headers.size(); i++) {
            headers.set(i, headers.get(i).trim());
            parameters.put(headers.get(i), new ArrayList<>());
        }
        headerRow = false;
    }

    public void readRows(String line, Map<String, List<String>> parameters) {
        rows = (asList(line.split(CSV_SEPARATOR)));
        for (int i = 0; i < rows.size(); i++) {
            String header = headers.get(i);
            String row = rows.get(i).trim();
            // Get the row list for a particular header and add a new value
            parameters.put(header, parameters.get(header)).add(row);
        }
    }
}
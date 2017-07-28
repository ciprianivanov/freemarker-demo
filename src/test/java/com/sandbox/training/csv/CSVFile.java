package com.sandbox.training.csv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class CSVFile {

    private final String CSV_SEPARATOR = ",";

    private boolean headerRow = true;
    private String[] headers;
    private String[] rows;

    private void read(String line, Map<String, String> parameters) {
        if (headerRow) {
            readHeaders(line);
        } else {
            readRows(line);
        }
    }

    public Map<String, String> getTestData() {

    }



    public void readHeaders(String line) {
        headers = line.split(CSV_SEPARATOR);
        headerRow = false;
    }

    public void readRows(String line) {
        rows = line.split(CSV_SEPARATOR);
    }
}
package com.sandbox.training.testng;

import com.sandbox.training.csv.CSVReader;
import com.sandbox.training.freemarker.FreemarkerEngine;
import freemarker.template.TemplateException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerEngineTest {

    CSVReader csvReader = new CSVReader();

    @Test
    public void freemarkerEngineXMLFileTest() throws IOException, TemplateException {
        FreemarkerEngine freemarkerEngine = new FreemarkerEngine("/testdata/freemarker/templates/");
        Map<String, String> templateParameters = new HashMap<>();

        templateParameters = csvReader.read("/testdata/freemarker/csv/parameters.csv");
        System.out.println(freemarkerEngine.parseTemplate("pacs.008.001.01", templateParameters));
    }

    @DataProvider(name = "freemarker")
    public static Object[][] freemarkerEngineXMLFileTestDataProvider() {

        return new Object[0][0];
    }

}

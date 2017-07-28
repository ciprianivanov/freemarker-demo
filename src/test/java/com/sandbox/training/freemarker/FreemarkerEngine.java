package com.sandbox.training.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerEngine {

    private final String TEMPLATE_EXT = ".ftl";

    private Configuration configuration;
    private StringWriter stringWriter;

    public FreemarkerEngine(String templateDirectory) {
        try {
            configuration = new Configuration(Configuration.VERSION_2_3_25);
            configuration.setDirectoryForTemplateLoading(getTemplateDirectory(templateDirectory));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStringWriter() {
        this.stringWriter = new StringWriter();
    }

    private Template setTemplate(String templateName) throws IOException {
        Template template = configuration.getTemplate(templateName + TEMPLATE_EXT);
        return template;
    }

    private File getTemplateDirectory(String templateDirectory) {
        return new File(getClass().getResource(templateDirectory).getPath());
    }

    private Map<String, String> getTemplateParametersFrom(Object[][] parameters) {

        Map<String, String> templateParameters = new HashMap<>();


        return templateParameters;
    }

    public String parseTemplate(String templateName, Map<String, String> parameters) throws IOException, TemplateException {
        createStringWriter();
        setTemplate(templateName).process(parameters, stringWriter);
        return stringWriter.toString();
    }

    public String parseTemplate(String templateName, Object[][] parameters) throws IOException, TemplateException {
        createStringWriter();
        setTemplate(templateName).process(parameters, stringWriter);
        return stringWriter.toString();
    }
}
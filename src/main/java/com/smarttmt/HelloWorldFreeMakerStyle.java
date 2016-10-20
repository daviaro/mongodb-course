package com.smarttmt;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adalbertdavidaroca on 10/19/16.
 */
public class HelloWorldFreeMakerStyle {
    public static void main(String[] args) {
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_25);
        configuration.setClassForTemplateLoading(HelloWorldFreeMakerStyle.class,"/");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

        /*Escribir en el template*/

        StringWriter sw= new StringWriter();
        Map<String,Object> helloMap= new HashMap<>();

        helloMap.put("name","freemaker");



        try {
            Template template= configuration.getTemplate("hello.ftl");

            template.process(helloMap,sw);

            System.out.println(sw);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}

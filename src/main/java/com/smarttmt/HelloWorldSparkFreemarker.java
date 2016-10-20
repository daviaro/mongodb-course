package com.smarttmt;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by adalbertdavidaroca on 10/20/16.
 */
public class HelloWorldSparkFreemarker {

    public static void main(String[] args) {

        Configuration configuration=new Configuration(Configuration.VERSION_2_3_25);
        configuration.setClassForTemplateLoading(HelloWorldFreeMakerStyle.class,"/");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

        get("/hello",(request, response) -> {
            StringWriter sw= new StringWriter();
            Map<String,Object> helloMap= new HashMap<>();
            helloMap.put("name","freemaker");
            Template template= configuration.getTemplate("hello.ftl");
            template.process(helloMap,sw);
            System.out.println(sw);
            return sw;
            });
    }
}

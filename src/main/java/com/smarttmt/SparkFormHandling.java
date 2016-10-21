package com.smarttmt;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by desarrollo001 on 20/10/2016.
 */
public class SparkFormHandling {

    public static void main(String[] args) {
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_25);
        configuration.setClassForTemplateLoading(SparkFormHandling.class,"/");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);

        get("/",(request, response) -> {
            StringWriter sw= new StringWriter();
            Map<String,Object> helloMap= new HashMap<>();
            helloMap.put("fruits", Arrays.asList("Apple","Orange","Banana","Peach"));
            Template template= configuration.getTemplate("fruit.ftl");
            template.process(helloMap,sw);
            System.out.println(sw);
            return sw;
        });

        post("/favorite_fruit",(request,response)->{
            String fruit= request.queryParams("fruit");

            if(fruit == null){
                return "Why don´t you pick one";
            }else{
                return "la fruta escogida es "+fruit;
            }
        });


    }
}

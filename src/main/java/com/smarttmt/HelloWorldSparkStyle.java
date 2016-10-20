package com.smarttmt;


import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

/**
 * Created by adalbertdavidaroca on 10/19/16.
 */
public class HelloWorldSparkStyle {

    public static void main(String[] args){
        /*get("/hello", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "Hello World Spark";
            }
        });*/

        get("/hello",(request, response) -> "Hola mundo Spark");
        get("/test",(request, response) -> {

            return "Esta es una pagina de prueba";
        });
        get("/echo/:thing",(request, response) -> {

            return "Esta es una pagina de prueba "+request.params(":thing");
        });
    }

}

package com.generate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Joe
 * Description:
 * Date: 2017-11-27
 */
@SpringBootApplication
@Controller
public class App {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}

package dataBuryingPoint.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description SampleController
 * @Author Administrator
 * @Date 2019/9/10 15:14
 * @Version 1.0
 **/
@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/dataBuryingPoint")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }
    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}

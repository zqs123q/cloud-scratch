package com.turnrut.colud.fake.alice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@SpringBootApplication
@RequestMapping("/hi")
public class AliceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliceApplication.class, args);
    }

    @Autowired
    BobService bobService;

    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String serverName;

    @GetMapping()
    public String hi(@RequestParam(value = "tag",
            defaultValue = "hi") String tag) {
        String s = tag + "-" + serverName + ":" + port;
        return bobService.hi(s);
    }
}

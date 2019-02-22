package com.turnrut.cloud.fake.bob;

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
public class BobApplication {
    public static void main(String[] args) {
        SpringApplication.run(BobApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String serverName;

    @GetMapping()
    public String hi(@RequestParam("tag") String tag) {
        String s = tag + "-" + serverName + ":" + port;
        return s;
    }
}

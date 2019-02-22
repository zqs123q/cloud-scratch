package com.turnrut.colud.fake.alice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bob")
public interface BobService {

    @GetMapping("hi")
    String hi(@RequestParam("tag") String tag);

}

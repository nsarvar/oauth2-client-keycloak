package com.example.demooauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UpayController {

    @GetMapping("/api/public")
    public String publicApi() {
        return "OK - public";
    }

    @GetMapping("/api/private")
    public String privateApi() {
        return "OK - private";
    }

    @GetMapping("/api/admin")
    public String adminApi() {
        return "OK - admin";
    }
}

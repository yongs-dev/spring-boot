package com.spring.mark.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String home(Authentication authentication) {
        logger.info("Authentication Principal: {}", authentication.getPrincipal());
        return "home";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}

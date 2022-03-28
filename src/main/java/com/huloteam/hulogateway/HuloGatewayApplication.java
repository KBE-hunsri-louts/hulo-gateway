package com.huloteam.hulogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HuloGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuloGatewayApplication.class, args);
    }

    @RestController
    static final class ExampleController {
        @GetMapping("/")
        String hello() {
            return "(^_^)/\n";
        }
    }

}

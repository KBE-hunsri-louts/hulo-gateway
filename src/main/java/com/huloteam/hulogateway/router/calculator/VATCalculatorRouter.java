package com.huloteam.hulogateway.router.calculator;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VATCalculatorRouter {

    final static int CALCULATOR_API_PORT = 8100;
    final static String BASE_URI = "http://host.docker.internal:"+CALCULATOR_API_PORT;

    /**
     * Looks for requests for the VATCalculator and forwards them to the VATCalculator microservice.
     *
     * @param builder the builder object that is used to rebuild the uri
     * @return the route locator holding the rerouted uri
     */
    @Bean
    public RouteLocator VATCalculatorRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rewrite_route", r -> r.host("localhost:8000")
                        .filters(f -> f.rewritePath("/calculator/(?<segment>.*)", "/calculator/${segment}"))
                        .uri(BASE_URI))
                .build();
    }
}

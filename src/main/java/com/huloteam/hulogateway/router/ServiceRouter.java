package com.huloteam.hulogateway.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRouter {

    final static int CALCULATOR_API_PORT = 8100;
    final static int CORE_API_PORT = 8200;
    final static String BASE_URI = "http://host.docker.internal:";


    /**
     * Looks for requests for services and forwards them to the according microservice.
     *
     * @param builder the builder object that is used to rebuild the uri
     * @return the route locator holding the rerouted uri
     */
    @Bean
    public RouteLocator ServiceRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/calculator/**")
                        .uri(BASE_URI+CALCULATOR_API_PORT))
                .route(r -> r.path("/application/**")
                        .uri(BASE_URI+CORE_API_PORT))
                .build();
    }
}

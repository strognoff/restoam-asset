package restoamar.web;


import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public interface ApplicationRoutes {
    static RouterFunction<?> routes(AssetHandler hotelHandler) {
        return nest(path("/restoam"),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(GET("/{id}"), hotelHandler::get)
                                .andRoute(POST("/"), hotelHandler::save)
                                .andRoute(PUT("/"), hotelHandler::update)
                                .andRoute(DELETE("/{id}"), hotelHandler::delete)
                ));
    }

}
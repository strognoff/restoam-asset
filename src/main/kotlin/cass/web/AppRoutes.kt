package cass.web

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router
import restoamar.web.AssetHandler


fun routes(assetHandler: AssetHandler): RouterFunction<*> {
    return router {
        ("/hotels" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/{id}", assetHandler::get)
            POST("/", assetHandler::save)
            PUT("/", assetHandler::update)
            DELETE("/{id}", assetHandler::delete)
        }
    }
}
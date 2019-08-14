package restoamar.config;

import cass.web.AppRoutesKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import restoamar.web.ApplicationRoutes;
import restoamar.web.AssetHandler;

@Configuration
public class WebConfig {

    @Autowired
    private AssetHandler assetHandler;

    @Bean
    public RouterFunction<?> routerFunction() {
        return ApplicationRoutes.routes(this.assetHandler);
    }
}

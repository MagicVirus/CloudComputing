package config;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import objects.StockService;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // Enable Spring DI and Jackson configuration
        register(RequestContextFilter.class);
        register(JacksonObjectMapperConfig.class);

        // Application resources
        register(StockService.class);
    }
}
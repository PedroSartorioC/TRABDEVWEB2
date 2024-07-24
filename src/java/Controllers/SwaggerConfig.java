package Controllers;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfig {
    public static void configureSwagger() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("API lanches");
        beanConfig.setVersion("1.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/Swagger");
        beanConfig.setResourcePackage("Controllers");
        beanConfig.setScan(true);
    }
}

package com.juba13.dynamicdashboardbackend;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The main application class for the Dashboard application.
 */
@EnableSwagger2
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebMvcConfigurer {

    /**
     * Entry point for the Dashboard application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Set system properties for configuration
        System.setProperty("server.servlet.context-path", AppConfig.CONTEXT_PATH);
        System.setProperty("server.port", AppConfig.SERVER_PORT);

        // Run the Spring Boot application
        SpringApplication.run(Application.class, args);
    }

    /**
     * Configures the SpringApplicationBuilder for the application.
     *
     * @param application The SpringApplicationBuilder to configure.
     * @return The configured SpringApplicationBuilder.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Configure the SpringApplicationBuilder
        return application.sources(Application.class);
    }

    /**
     * Configures Swagger documentation for the API.
     *
     * @return A Docket instance for configuring Swagger.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Restfulinpeace")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Defines the API information for Swagger.
     *
     * @return An ApiInfo instance with API details.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Dynamic Dashboard API")
                .description("This beck-end service provided all type of api service for Dynamic Dashboard")
                .version("1.0")
                .build();
    }

    @Autowired
    private AuthInterceptor authInterceptor;

    /**
     * Configures custom interceptor for authentication.
     *
     * @param registry The InterceptorRegistry to configure.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(AppConfig.FILTERRING_PATH_PATTERNS)
                .excludePathPatterns(Arrays.asList(AppConfig.NONFILTERRING_PATH_PATTERNS));
    }

    /**
     * Configures Cross-Origin Resource Sharing (CORS) settings.
     *
     * @param registry The CorsRegistry to configure.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("POST", "OPTIONS");
    }
}

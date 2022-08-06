package me.anisimov.steamchecker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class MainConfiguration {

    @Bean
    public RestTemplate steamSender() {
        return new RestTemplate();
    }

}

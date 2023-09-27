package co.simplon.itp3.storageapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RestTemplate restTemplate() {

	return new RestTemplate();
    }

}

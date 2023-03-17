package edu.comillas.icai.gitt.pat.spring.mvc.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ConfiguracionClienteHttp {
    @Value("${cliente.http.timeout}")
    private long timeout;

    @Bean
    public RestTemplate clienteHttp() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(timeout))
                .setReadTimeout(Duration.ofSeconds(timeout))
                .build();
    }
}

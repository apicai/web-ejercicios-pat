package edu.comillas.icai.gitt.pat.spring.mvc.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ControladorRestE2ETest {

    private final TestRestTemplate restTemplate =
            new TestRestTemplate("administrador", "clave");

    @Test
    public void contadorExistenteTest() {
        // Given ...
        String contador = "{\"nombre\":\"visitas\",\"valor\":0}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.exchange(
                "http://localhost:8080/api/contadores", HttpMethod.POST,
                new HttpEntity<>(contador, headers), String.class);
        // When ...
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080/api/contadores/visitas",
                HttpMethod.GET, HttpEntity.EMPTY, String.class);
        // Then ...
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(contador, response.getBody());
    }

    @Test
    public void contadorNoExistenteTest() {
        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:8080/api/contadores/no-existo",
                HttpMethod.GET, HttpEntity.EMPTY, Void.class);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
package edu.comillas.icai.gitt.pat.spring.mvc.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControladorRestE2ETest {

    private final TestRestTemplate restTemplate =
            new TestRestTemplate("administrador", "clave");

    @BeforeAll
    public void beforeAll() {
        restTemplate.exchange(
                "http://localhost:8080/api/contadores", HttpMethod.POST,
                new HttpEntity<>(new ModeloContador("visitas", 0L)), ModeloContador.class);
    }

    @Test
    public void contadorExistenteTest() {
        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:8080/api/contadores/visitas",
                HttpMethod.GET, HttpEntity.EMPTY, Void.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void contadorNoExistenteTest() {
        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:8080/api/contadores/no-existo",
                HttpMethod.GET, HttpEntity.EMPTY, Void.class);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
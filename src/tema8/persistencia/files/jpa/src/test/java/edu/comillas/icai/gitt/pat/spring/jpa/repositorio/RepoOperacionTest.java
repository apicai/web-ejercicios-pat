package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RepoOperacionTest {
    @Autowired
    RepoOperacion repoOperacion;

    @Test
    void integridadReferencialTest() {
        Usuario usuario = new Usuario();
        usuario.id = 1L;
        Contador contador = new Contador();
        contador.id = 200L;
        Operacion operacion = new Operacion();
        operacion.tipo = "creación";
        operacion.fecha = Timestamp.from(Instant.now());
        operacion.contador = contador;
        operacion.usuario = usuario;

        DataIntegrityViolationException error = null;
        try {
            repoOperacion.save(operacion);
        } catch (DataIntegrityViolationException e) {
            error = e;
        }
        assertNotNull(error);
    }
}
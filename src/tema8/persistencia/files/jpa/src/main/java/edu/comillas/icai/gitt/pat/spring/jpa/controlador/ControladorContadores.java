package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoContador;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoUsuario;
import edu.comillas.icai.gitt.pat.spring.jpa.servicio.ServicioContadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Optional;

@RestController
public class ControladorContadores {
    @Autowired
    ServicioContadores servicio;

    @PostMapping("/api/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    public Contador crea(@RequestBody Contador contadorNuevo, @RequestHeader("Authorization") String credenciales) {
        Usuario usuario = servicio.autentica(credenciales);
        return servicio.crea(contadorNuevo, usuario);
    }

    @GetMapping("/api/contadores/{nombre}")
    public Contador lee(@PathVariable String nombre, @RequestHeader("Authorization") String credenciales) {
        Usuario usuario = servicio.autentica(credenciales);
        return servicio.lee(nombre, usuario);
    }

    @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
    public Contador incrementa(@PathVariable String nombre, @PathVariable Long incremento, @RequestHeader("Authorization") String credenciales) {
        Usuario usuario = servicio.autentica(credenciales);
        Contador contador = servicio.lee(nombre, usuario);
        return servicio.incrementa(contador, incremento, usuario);
    }

    @DeleteMapping("/api/contadores/{nombre}")
    public void borra(@PathVariable String nombre, @RequestHeader("Authorization") String credenciales) {
        Usuario usuario = servicio.autentica(credenciales);
        Contador contador = servicio.lee(nombre, usuario);
        servicio.borra(contador, usuario);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void contadorIncorrecto(DataIntegrityViolationException ex) {}

}


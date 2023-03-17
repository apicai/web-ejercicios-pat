package edu.comillas.icai.gitt.pat.spring.mvc.rest;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControladorRest {

    private final Map<String, ModeloContador> contadores = new HashMap<>();

    @PostMapping("/api/contadores/{nombre}")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloContador crea(@PathVariable String nombre) {
        return crea(new ModeloContador(nombre, 0L), null);
    }

    @PostMapping("/api/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ModeloContador crea(@Valid @RequestBody ModeloContador contadorNuevo, BindingResult result) {
        if (result != null && result.hasErrors()) {
            throw new ExcepcionContadorIncorrecto(result);
        }
        if (contadores.containsKey(contadorNuevo.nombre())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        contadores.put(contadorNuevo.nombre(), contadorNuevo);
        return contadorNuevo;
    }

    @GetMapping("/api/contadores/{nombre}")
    public ModeloContador contador(@PathVariable String nombre) {
        return busca(nombre);
    }

    @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
    public ModeloContador incrementa(@PathVariable String nombre, @PathVariable Integer incremento) {
        ModeloContador contadorActual = busca(nombre);
        ModeloContador contadorIncrementado = new ModeloContador(nombre, contadorActual.valor() + incremento);
        contadores.put(nombre, contadorIncrementado);
        return contadorIncrementado;
    }

    @DeleteMapping("/api/contadores/{nombre}")
    @PreAuthorize("hasRole('ADMIN')")
    public void borra(@PathVariable String nombre) {
        contadores.remove(nombre);
    }

    @ExceptionHandler(ExcepcionContadorIncorrecto.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ModeloCampoIncorrecto> contadorIncorrecto(ExcepcionContadorIncorrecto ex) {
        return ex.getErrores().stream().map(error ->
                new ModeloCampoIncorrecto(error.getDefaultMessage(), error.getField(), error.getRejectedValue())
        ).toList();
    }

    private ModeloContador busca(String nombre) {
        if (!contadores.containsKey(nombre)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contadores.get(nombre);
    }
}

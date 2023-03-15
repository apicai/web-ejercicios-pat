package edu.comillas.icai.gitt.pat.spring.mvc.rest;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
import java.util.Map;

@RestController
public class ControladorRest {

    private final Map<String, ModeloContador> contadores = new HashMap<>();

    @PostMapping("/contadores/{nombre}")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloContador crea(@PathVariable String nombre) {
        return crea(new ModeloContador(nombre, 0L), null);
    }

    @PostMapping("/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloContador crea(@Valid @RequestBody ModeloContador contadorNuevo, BindingResult result) {
        if (result != null && result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (contadores.containsKey(contadorNuevo.nombre())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        contadores.put(contadorNuevo.nombre(), contadorNuevo);
        return contadorNuevo;
    }

    @GetMapping("/contadores/{nombre}")
    public ModeloContador contador(@PathVariable String nombre) {
        return busca(nombre);
    }

    @PutMapping("/contadores/{nombre}/incrementa")
    public ModeloContador incrementa(@PathVariable String nombre) {
        ModeloContador contadorActual = busca(nombre);
        ModeloContador contadorIncrementado = new ModeloContador(nombre, contadorActual.valor() + 1);
        contadores.put(nombre, contadorIncrementado);
        return contadorIncrementado;
    }

    @DeleteMapping("/contadores/{nombre}")
    public void borra(@PathVariable String nombre) {
        contadores.remove(nombre);
    }

    @ExceptionHandler(ExcepcionContadorNoExistente.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModeloError contadorNoExistente(ExcepcionContadorNoExistente ex) {
        return new ModeloError(ex.getMessage());
    }

    private ModeloContador busca(String nombre) {
        if (!contadores.containsKey(nombre)) {
            throw new ExcepcionContadorNoExistente("El contador '" + nombre + "' no existe");
        }
        return contadores.get(nombre);
    }
}

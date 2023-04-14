package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoContador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControladorContadores {
    @Autowired
    RepoContador repoContador;

    @PostMapping("/api/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    public Contador crea(@RequestBody Contador contadorNuevo) {
        return repoContador.save(contadorNuevo);
    }

    @GetMapping("/api/contadores/{nombre}")
    public Contador lee(@PathVariable String nombre) {
        Contador contador = repoContador.findByNombre(nombre);
        if (contador == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contador;
    }

    @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
    public Contador incrementa(@PathVariable String nombre, @PathVariable Long incremento) {
        Contador contador = lee(nombre);
        contador.valor += incremento;
        return repoContador.save(contador);
    }

    @DeleteMapping("/api/contadores/{nombre}")
    public void borra(@PathVariable String nombre) {
        repoContador.borraPorNombre(nombre);
    }
}


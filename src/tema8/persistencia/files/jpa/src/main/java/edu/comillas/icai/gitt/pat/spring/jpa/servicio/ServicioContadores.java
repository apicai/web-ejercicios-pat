package edu.comillas.icai.gitt.pat.spring.jpa.servicio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoContador;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoOperacion;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ServicioContadores {
    @Autowired
    RepoUsuario repoUsuario;
    @Autowired
    RepoContador repoContador;
    @Autowired
    RepoOperacion repoOperacion;

    public Usuario autentica(String credenciales) {
        Usuario usuario = repoUsuario.findByCredenciales(credenciales);
        if (usuario != null) {
            return usuario;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    public Contador crea(Contador contadorNuevo, Usuario usuario) {
        Contador contador = repoContador.save(contadorNuevo);
        Operacion operacion = new Operacion();
        operacion.contadorId = contador.id;
        operacion.usuarioId = usuario.id;
        operacion.fecha = Timestamp.from(Instant.now());
        operacion.tipo = "CREATE";
        repoOperacion.save(operacion);
        return contador;
    }
    public Contador lee(String nombre, Usuario usuario) {
        Contador contador = repoContador.findByNombre(nombre);
        if (contador == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Operacion operacion = new Operacion();
        operacion.contadorId = contador.id;
        operacion.usuarioId = usuario.id;
        operacion.fecha = Timestamp.from(Instant.now());
        operacion.tipo = "READ";
        repoOperacion.save(operacion);
        return contador;
    }
    public Contador incrementa(Contador contador, Long incremento, Usuario usuario) {
        contador.valor += incremento;
        contador = repoContador.save(contador);
        Operacion operacion = new Operacion();
        operacion.contadorId = contador.id;
        operacion.usuarioId = usuario.id;
        operacion.fecha = Timestamp.from(Instant.now());
        operacion.tipo = "UPDATE";
        repoOperacion.save(operacion);
        return contador;
    }
    public void     borra(Contador contador, Usuario usuario) {
        repoContador.delete(contador);
        Operacion operacion = new Operacion();
        operacion.contadorId = contador.id;
        operacion.usuarioId = usuario.id;
        operacion.fecha = Timestamp.from(Instant.now());
        operacion.tipo = "DELETE";
        repoOperacion.save(operacion);
    }
}


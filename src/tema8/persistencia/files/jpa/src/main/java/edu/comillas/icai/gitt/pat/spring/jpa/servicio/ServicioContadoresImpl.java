package edu.comillas.icai.gitt.pat.spring.jpa.servicio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoContador;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoOperacion;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoUsuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class ServicioContadoresImpl implements ServicioContadores {
    @Autowired
    RepoContador repoContador;
    @Autowired
    RepoOperacion repoOperacion;
    @Autowired
    RepoUsuario repoUsuario;

    @Override
    public Usuario autentica(String credenciales) {
        Usuario usuario = repoUsuario.findByCredenciales(credenciales);
        if (usuario == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return usuario;
    }
    @Override
    @Transactional
    public Contador crea(Contador contadorNuevo, Usuario usuario) {
        Contador contador = repoContador.save(contadorNuevo);
        return operacion(usuario, contador, "creación");
    }
    @Override
    @Transactional
    public Contador lee(String nombre, Usuario usuario) {
        Contador contador = repoContador.findByNombre(nombre);
        if (contador == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return usuario == null ? contador : operacion(usuario, contador, "lectura");
    }
    @Override
    @Transactional
    public Contador incrementa(Contador contador, Long incremento, Usuario usuario) {
        contador.valor += incremento;
        repoContador.save(contador);
        return operacion(usuario, contador, "incremento");
    }
    @Override
    @Transactional
    public void borra(Contador contador, Usuario usuario) {
        operacion(usuario, contador, "borrado");
        repoContador.delete(contador);
    }

    @Override
    public List<Operacion> operaciones(Contador contador) {
        // return repoOperacion.findByContadorId(contador.id);
        return repoOperacion.findByContador(contador);
    }

    private Contador operacion(Usuario usuario, Contador contador, String tipo) {
        Operacion operacion = new Operacion();
        // operacion.contadorId = contador.id;
        // operacion.usuarioId = usuario.id;
        operacion.contador = contador;
        operacion.usuario = usuario;
        operacion.tipo = tipo;
        operacion.fecha = Timestamp.from(Instant.now());
        repoOperacion.save(operacion);
        return contador;
    }
}

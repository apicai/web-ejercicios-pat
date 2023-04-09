package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoOperacion extends CrudRepository<Operacion, Long> {
    // List<Operacion> findByContadorId(Long contadorId);
    List<Operacion> findByContador(Contador contador);
}

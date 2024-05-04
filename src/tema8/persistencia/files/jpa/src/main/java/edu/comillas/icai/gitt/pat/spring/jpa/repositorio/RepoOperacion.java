package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepoOperacion extends CrudRepository<Operacion, Long> {
}

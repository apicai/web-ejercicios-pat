package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepoContador extends CrudRepository<Contador, Long> {
    Contador findByNombre(String name);
    @Transactional
    @Modifying
    @Query(value = "DELETE contador WHERE nombre = :nombre", nativeQuery = true)
    void borraPorNombre(String nombre);
}

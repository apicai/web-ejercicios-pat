package edu.comillas.icai.gitt.pat.spring.jpa.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

@Entity
public class Operacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    // @Column(nullable = false) public Long usuarioId;
    @ManyToOne(optional = false) @OnDelete(action = OnDeleteAction.CASCADE) public Usuario usuario;
    // @Column(nullable = false) public Long contadorId;
    @ManyToOne(optional = false) @OnDelete(action = OnDeleteAction.CASCADE) public Contador contador;
    @Column(nullable = false) public String tipo;
    @Column(nullable = false) public Timestamp fecha;
}

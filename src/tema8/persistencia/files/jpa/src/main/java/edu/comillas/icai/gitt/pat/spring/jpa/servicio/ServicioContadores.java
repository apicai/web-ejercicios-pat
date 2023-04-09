package edu.comillas.icai.gitt.pat.spring.jpa.servicio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;

import java.util.List;

public interface ServicioContadores {
    Usuario autentica(String credenciales);
    Contador lee(String nombre, Usuario usuario);
    Contador crea(Contador contadorNuevo, Usuario usuario);
    Contador incrementa(Contador contador, Long incremento, Usuario usuario);
    void borra(Contador contador, Usuario usuario);
    List<Operacion> operaciones(Contador contador);
}

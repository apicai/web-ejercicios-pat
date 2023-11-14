package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControladorUsuario {
    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("/api/usuarios/{email}/login")
    public ResponseEntity<Usuario> login(@PathVariable String email, @RequestHeader(value = "Authorization", required = false) String credenciales) {
        Usuario usuario = credenciales == null ? null : repoUsuario.findByCredenciales(credenciales);
        if (usuario == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        ResponseCookie sesion = ResponseCookie
                .from("session", usuario.id.toString())
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .sameSite("Strict")
                .build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, sesion.toString()).body(usuario);
    }

    @GetMapping("/api/usuarios/{email}/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie sesion = ResponseCookie
                .from("session")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0)
                .sameSite("Strict")
                .build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, sesion.toString()).build();
    }

    @PostMapping("/api/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario alta(@RequestBody Usuario usuario, @RequestHeader(value = "Authorization") String credenciales) {
        usuario.credenciales = credenciales;
        usuario.rol = "USER";
        try {
            return repoUsuario.save(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

}


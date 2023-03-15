package edu.comillas.icai.gitt.pat.spring.mvc.ssr;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModeloFormularioContacto(
        @NotBlank(message = "El mensaje no puede estar vacío")
        @Size(max = 20)
        String mensaje,
        @Email(message = "El formato del email es incorrecto")
        @NotBlank(message = "El email es obligatorio")
        String email
) {}

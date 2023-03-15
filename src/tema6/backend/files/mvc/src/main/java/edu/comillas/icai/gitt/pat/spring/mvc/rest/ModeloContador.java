package edu.comillas.icai.gitt.pat.spring.mvc.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModeloContador(@NotBlank String nombre, @NotNull Long valor) { }



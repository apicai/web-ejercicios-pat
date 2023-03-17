package edu.comillas.icai.gitt.pat.spring.mvc.tareas;

import jakarta.validation.constraints.NotNull;

public record ModeloXkcd(@NotNull String title, @NotNull String alt, @NotNull Integer num) { }

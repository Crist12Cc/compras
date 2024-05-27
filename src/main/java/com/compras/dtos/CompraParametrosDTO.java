package com.compras.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraParametrosDTO {

    @NotNull(message = "Comercio es requerido")
    private UUID comercioId;

    @NotNull(message = "La fecha de inicio es obligaroria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligaroria")
    private LocalDate fechaFin;

}

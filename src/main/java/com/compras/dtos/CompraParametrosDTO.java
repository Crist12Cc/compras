package com.compras.dtos;

import com.compras.entities.ComercioCliente;
import com.compras.entities.Compra;
import com.compras.entities.Comprador;
import com.compras.enums.MedioPago;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

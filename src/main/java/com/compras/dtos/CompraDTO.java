package com.compras.dtos;

import com.compras.enums.MedioPago;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraDTO {

    private UUID id;

    private LocalDate fecha;

    private MedioPago medioPago;

    private Double montoTotal;

    private ComercioClienteDTO comercioCliente;

    private CompradorDTO comprador;

}

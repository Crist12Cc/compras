package com.compras.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraDTO {

    private UUID id;

    private String nombre;

    private String ubicacion;

    private UUID idComercioCliente;

    private UUID idComprador;
}

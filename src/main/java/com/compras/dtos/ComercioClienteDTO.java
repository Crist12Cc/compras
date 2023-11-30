package com.compras.dtos;

import com.compras.entities.ComercioCliente;
import com.compras.entities.Comprador;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComercioClienteDTO {

    private UUID id;

    private String nombre;

    private String ubicacion;

    public ComercioCliente toEntity(){
        return ComercioCliente.builder().id(this.id).nombre(this.nombre).
        ubicacion(this.ubicacion).build();
    }
}

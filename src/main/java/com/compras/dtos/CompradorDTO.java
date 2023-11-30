package com.compras.dtos;

import com.compras.entities.Comprador;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompradorDTO {
    private UUID id;

    private String nombre;

    public Comprador toEntity(){
        return Comprador.builder().id(this.id).nombre(this.nombre).build();
    }
}

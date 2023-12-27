package com.compras.dtos;

import com.compras.entities.Comprador;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompradorDTO {

    private UUID id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    public Comprador toEntity() {
        return Comprador.builder().id(this.id).nombre(this.nombre).build();
    }

}

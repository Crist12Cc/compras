package com.compras.dtos;

import com.compras.entities.ComercioCliente;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComercioClienteDTO {

    private UUID id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La ubicacion es obligatoria")
    private String ubicacion;

    public ComercioCliente toEntity() {
        return ComercioCliente.builder().id(this.id).nombre(this.nombre).ubicacion(this.ubicacion).build();
    }

}

package com.compras.entities;

import com.compras.dtos.ComercioClienteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComercioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;

    private String ubicacion;

    @OneToMany(mappedBy = "comercioCliente")
    private List<Compra> compra;

    public ComercioClienteDTO toDTO() {
        return ComercioClienteDTO.builder().id(this.id).nombre(this.nombre).ubicacion(this.ubicacion).build();
    }

}

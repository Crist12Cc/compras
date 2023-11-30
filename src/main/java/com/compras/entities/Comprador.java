package com.compras.entities;

import com.compras.dtos.CompradorDTO;
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
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;

    @OneToMany(mappedBy = "comprador")
    private List<Compra> compra;

    public CompradorDTO toDTO(){
        return CompradorDTO.builder().id(this.id).nombre(this.nombre).build();
    }

}

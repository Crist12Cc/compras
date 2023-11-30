package com.compras.entities;

import com.compras.enums.MedioPago;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    private Double montoTotal;

    @ManyToOne
    private ComercioCliente comercioCliente;

    @ManyToOne
    private Comprador comprador;

}

package com.compras.dtos;

import com.compras.entities.ComercioCliente;
import com.compras.entities.Compra;
import com.compras.entities.Comprador;
import com.compras.enums.MedioPago;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraPeticionDTO {

    private UUID id;

    private LocalDate fecha;

    private MedioPago medioPago;

    private Double montoTotal;

    private UUID idComercioCliente;

    private UUID idComprador;

    public Compra toEntity(ComercioCliente comercioCliente, Comprador comprador) {
        return Compra.builder().id(this.id).fecha(this.fecha).medioPago(this.medioPago).montoTotal(this.montoTotal)
                .comercioCliente(comercioCliente).comprador(comprador).build();
    }

}

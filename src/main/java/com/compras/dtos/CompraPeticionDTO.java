package com.compras.dtos;

import com.compras.entities.ComercioCliente;
import com.compras.entities.Compra;
import com.compras.entities.Comprador;
import com.compras.enums.MedioPago;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Fecha es obligaroria")
    private LocalDate fecha;

    @NotNull(message = "El medio de pago es obligarorio")
    private MedioPago medioPago;

    @NotNull(message = "El monto total es obligarorio")
    private Double montoTotal;

    @NotNull(message = "Comercio es obligarorio")
    private UUID idComercioCliente;

    @NotNull(message = "El comprador es obligarorio")
    private UUID idComprador;

    public Compra toEntity(ComercioCliente comercioCliente, Comprador comprador) {
        return Compra.builder().id(this.id).fecha(this.fecha).medioPago(this.medioPago).montoTotal(this.montoTotal)
                .comercioCliente(comercioCliente).comprador(comprador).build();
    }

}

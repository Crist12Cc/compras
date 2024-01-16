package com.compras.repositories;

import com.compras.entities.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface CompraRepo extends JpaRepository<Compra, UUID> {

    @Query("""
    SELECT c FROM Compra c
    WHERE c.comercioCliente.id = :comercioClienteId AND c.fecha BETWEEN :fechaInicio AND :fechaFin
    """)
    Page<Compra> buscarPorComercioYFechas(
            @Param("comercioClienteId") UUID comercioClienteId, @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin, Pageable pageable);

}

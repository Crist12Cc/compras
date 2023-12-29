package com.compras.services;

import com.compras.dtos.CompraDTO;
import com.compras.dtos.CompraPeticionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CompraServ {

    CompraDTO crear(CompraPeticionDTO compraPeticionDTO);

    CompraDTO leerPorID(UUID id);

    Page<CompraDTO> leer(Pageable pageable);

    CompraDTO actualizar(UUID id, CompraPeticionDTO compraPeticionDTO);

    CompraDTO eliminar(UUID id);
}

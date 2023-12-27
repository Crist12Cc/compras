package com.compras.services;

import com.compras.dtos.CompradorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CompradorServ {

    CompradorDTO crear(CompradorDTO compradorDTO);

    CompradorDTO leerPorID(UUID id);

    Page<CompradorDTO> leer(Pageable pageable);

    CompradorDTO actualizar(UUID id, CompradorDTO compradorDTO);

    CompradorDTO eliminar(UUID id);
}

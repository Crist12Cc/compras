package com.compras.services;

import com.compras.dtos.ComercioClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ComercioClienteServ {

    ComercioClienteDTO crear(ComercioClienteDTO comercioClienteDTO);

    ComercioClienteDTO leerPorID(UUID id);

    Page<ComercioClienteDTO> leer(Pageable pageable);

    ComercioClienteDTO actualizar(UUID id, ComercioClienteDTO comercioClienteDTO);

    ComercioClienteDTO eliminar(UUID id);

}

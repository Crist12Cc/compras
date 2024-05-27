package com.compras.services_impl;

import com.compras.dtos.CompradorDTO;
import com.compras.entities.Comprador;
import com.compras.repositories.CompradorRepo;
import com.compras.services.CompradorServ;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompradorServImpl implements CompradorServ {

    private final CompradorRepo compradorRepo;

    @Override
    public CompradorDTO crear(CompradorDTO compradorDTO) {
        return compradorRepo.save(compradorDTO.toEntity()).toDTO();
    }

    @Override
    public CompradorDTO leerPorID(UUID id) {
        Comprador comprador = compradorRepo.findById(id).orElse(null);
        if (comprador == null) {
            return null;
        } else {
            return comprador.toDTO();
        }
    }

    @Override
    public Page<CompradorDTO> leer(Pageable pageable) {
        return compradorRepo.findAll(pageable).map(Comprador::toDTO);
    }

    @Override
    public CompradorDTO actualizar(UUID id, CompradorDTO compradorDTO) {
        CompradorDTO comprador = leerPorID(id);
        if (comprador == null) {
            return null;
        }
        compradorDTO.setId(id);
        return compradorRepo.save(compradorDTO.toEntity()).toDTO();
    }

    @Override
    public CompradorDTO eliminar(UUID id) {
        CompradorDTO comprador = leerPorID(id);
        if (comprador == null) {
            return null;
        }
        compradorRepo.delete(comprador.toEntity());
        return comprador;
    }

}

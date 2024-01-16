package com.compras.servicesImpl;

import com.compras.dtos.ComercioClienteDTO;
import com.compras.entities.ComercioCliente;
import com.compras.repositories.ComercioClienteRepo;
import com.compras.services.ComercioClienteServ;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ComercioClienteServImpl implements ComercioClienteServ {

    private final ComercioClienteRepo comercioClienteRepo;

    @Override
    public ComercioClienteDTO crear(ComercioClienteDTO comercioClienteDTO) {
        return comercioClienteRepo.save(comercioClienteDTO.toEntity()).toDTO();
    }

    @Override
    public ComercioClienteDTO leerPorID(UUID id) {
        ComercioCliente comercioCliente = comercioClienteRepo.findById(id).orElse(null);
        if (comercioCliente == null) {
            return null;
        } else {
            return comercioCliente.toDTO();
        }
    }

    @Override
    public Page<ComercioClienteDTO> leer(Pageable pageable) {
        return comercioClienteRepo.findAll(pageable).map(ComercioCliente::toDTO);
    }

    @Override
    public ComercioClienteDTO actualizar(UUID id, ComercioClienteDTO comercioClienteDTO) {
        ComercioClienteDTO comercioCliente = leerPorID(id);
        if (comercioCliente == null) {
            return null;
        }
        comercioClienteDTO.setId(id);
        return comercioClienteRepo.save(comercioClienteDTO.toEntity()).toDTO();
    }

    @Override
    public ComercioClienteDTO eliminar(UUID id) {
        ComercioClienteDTO comercioCliente = leerPorID(id);
        if (comercioCliente == null) {
            return null;
        }
        comercioClienteRepo.delete(comercioCliente.toEntity());
        return comercioCliente;
    }

}

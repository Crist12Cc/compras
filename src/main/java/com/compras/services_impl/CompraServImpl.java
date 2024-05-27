package com.compras.services_impl;

import com.compras.dtos.*;
import com.compras.entities.Compra;
import com.compras.repositories.CompraRepo;
import com.compras.services.ComercioClienteServ;
import com.compras.services.CompraServ;
import com.compras.services.CompradorServ;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompraServImpl implements CompraServ {

    private final CompraRepo compraRepo;
    private final ComercioClienteServ comercioClienteServ;
    private final CompradorServ compradorServ;

    @Override
    public CompraDTO crear(CompraPeticionDTO compraPeticionDTO) {
        ComercioClienteDTO comercioClienteDTO = comercioClienteServ.leerPorID(compraPeticionDTO.getIdComercioCliente());
        if (comercioClienteDTO == null) {
            return null;
        }
        CompradorDTO compradorDTO = compradorServ.leerPorID(compraPeticionDTO.getIdComprador());
        if (compradorDTO == null) {
            return null;
        }
        return compraRepo.save(compraPeticionDTO.toEntity(comercioClienteDTO.toEntity(),
                compradorDTO.toEntity())).toDTO();
    }

    @Override
    public CompraDTO leerPorID(UUID id) {
        Compra compra = compraRepo.findById(id).orElse(null);
        if (compra == null) {
            return null;
        } else {
            return compra.toDTO();
        }
    }

    @Override
    public Page<CompraDTO> leer(Pageable pageable) {
        return compraRepo.findAll(pageable).map(Compra::toDTO);
    }

    @Override
    public CompraDTO actualizar(UUID id, CompraPeticionDTO compraPeticionDTO) {
        CompraDTO compra = leerPorID(id);
        if (compra == null) {
            return null;
        }
        ComercioClienteDTO comercioClienteDTO = comercioClienteServ.leerPorID(compraPeticionDTO.getIdComercioCliente());
        if (comercioClienteDTO == null) {
            return null;
        }
        CompradorDTO compradorDTO = compradorServ.leerPorID(compraPeticionDTO.getIdComprador());
        if (compradorDTO == null) {
            return null;
        }
        compraPeticionDTO.setId(id);
        return compraRepo.save(compraPeticionDTO.toEntity(comercioClienteDTO.toEntity(),
                compradorDTO.toEntity())).toDTO();
    }

    @Override
    public CompraDTO eliminar(UUID id) {
        CompraDTO compra = leerPorID(id);
        if (compra == null) {
            return null;
        }
        compraRepo.deleteById(id);
        return compra;
    }

    @Override
    public Page<CompraDTO> buscarPorComercioYFechas(CompraParametrosDTO compraParametrosDTO, Pageable pageable) {
        return compraRepo.buscarPorComercioYFechas(compraParametrosDTO.getComercioId(),
                compraParametrosDTO.getFechaInicio(), compraParametrosDTO.getFechaFin(), pageable).map(Compra::toDTO);
    }

}

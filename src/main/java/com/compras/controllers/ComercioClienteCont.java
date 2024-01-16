package com.compras.controllers;

import com.compras.dtos.ComercioClienteDTO;
import com.compras.services.ComercioClienteServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comercio-cliente")
@RequiredArgsConstructor
public class ComercioClienteCont {

    private final ComercioClienteServ comercioClienteServ;

    @PostMapping
    public ResponseEntity<ComercioClienteDTO> crear(@Valid @RequestBody ComercioClienteDTO comercioClienteDTO) {
        comercioClienteServ.crear(comercioClienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComercioClienteDTO> leerPorID(@PathVariable UUID id) {
        ComercioClienteDTO comercioClienteDTO = comercioClienteServ.leerPorID(id);
        if (comercioClienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comercioClienteDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ComercioClienteDTO>> leer(Pageable pageable) {
        return ResponseEntity.ok(comercioClienteServ.leer(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComercioClienteDTO> actualizar(
            @PathVariable UUID id, @Valid @RequestBody ComercioClienteDTO comercioClienteDTO) {
        ComercioClienteDTO comercioCliente = comercioClienteServ.actualizar(id, comercioClienteDTO);
        if (comercioCliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ComercioClienteDTO> eliminar(@PathVariable UUID id) {
        ComercioClienteDTO comercioCliente = comercioClienteServ.eliminar(id);
        if (comercioCliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}

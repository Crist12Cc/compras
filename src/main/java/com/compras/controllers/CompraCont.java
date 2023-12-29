package com.compras.controllers;

import com.compras.dtos.CompraDTO;
import com.compras.dtos.CompraPeticionDTO;
import com.compras.services.CompraServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraCont {

    private final CompraServ compraServ;

    @PostMapping
    public ResponseEntity<CompraDTO> crear(@Valid @RequestBody CompraPeticionDTO compraPeticionDTO) {
        CompraDTO comprador = compraServ.crear(compraPeticionDTO);
        if (comprador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> leerPorID(@PathVariable UUID id) {
        CompraDTO compradorDTO = compraServ.leerPorID(id);
        if (compradorDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compradorDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CompraDTO>> leer(Pageable pageable) {
        return ResponseEntity.ok(compraServ.leer(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraDTO> actualizar(
            @PathVariable UUID id, @Valid @RequestBody CompraPeticionDTO compraPeticionDTO) {
        CompraDTO comprador = compraServ.actualizar(id, compraPeticionDTO);
        if (comprador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompraDTO> eliminar(@PathVariable UUID id) {
        CompraDTO comprador = compraServ.eliminar(id);
        if (comprador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}

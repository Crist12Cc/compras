package com.compras.controllers;

import com.compras.dtos.CompradorDTO;
import com.compras.services.CompradorServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comprador")
@RequiredArgsConstructor
public class CompradorCont {

    private final CompradorServ compradorServ;

    @PostMapping
    public ResponseEntity<CompradorDTO> crear(@Valid @RequestBody CompradorDTO compradorDTO) {
        compradorServ.crear(compradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompradorDTO> leerPorID(@PathVariable UUID id) {
        CompradorDTO compradorDTO = compradorServ.leerPorID(id);
        if (compradorDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compradorDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CompradorDTO>> leer(Pageable pageable) {
        return ResponseEntity.ok(compradorServ.leer(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompradorDTO> actualizar(@PathVariable UUID id,
                                                   @Valid @RequestBody CompradorDTO compradorDTO) {
        CompradorDTO comprador = compradorServ.actualizar(id, compradorDTO);
        if (comprador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompradorDTO> eliminar(@PathVariable UUID id) {
        CompradorDTO comprador = compradorServ.eliminar(id);
        if (comprador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}

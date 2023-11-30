package com.compras.repositories;

import com.compras.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompraRepo extends JpaRepository<Compra, UUID> {
}

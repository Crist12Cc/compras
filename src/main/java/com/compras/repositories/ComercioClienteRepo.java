package com.compras.repositories;

import com.compras.entities.ComercioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComercioClienteRepo extends JpaRepository<ComercioCliente, UUID> {
}

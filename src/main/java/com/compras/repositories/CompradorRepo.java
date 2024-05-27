package com.compras.repositories;

import com.compras.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompradorRepo extends JpaRepository<Comprador, UUID> {

}

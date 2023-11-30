package com.compras.servicesImpl;

import com.compras.repositories.ComercioClienteRepo;
import com.compras.repositories.CompradorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComercioClienteServImpl {

    private final ComercioClienteRepo comercioClienteRepo;
}

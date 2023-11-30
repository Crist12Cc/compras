package com.compras.servicesImpl;

import com.compras.repositories.CompradorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompradorServImpl {

    private final CompradorRepo compradorRepo;
}

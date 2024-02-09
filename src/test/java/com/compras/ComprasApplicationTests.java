package com.compras;

import com.compras.dtos.ComercioClienteDTO;
import com.compras.services.ComercioClienteServ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ComprasApplicationTests {
    @Autowired
    private ComercioClienteServ comercioClienteServ;

    @Test
    void contextLoads() {
        UUID uuid = UUID.fromString("ffd8ec44-1aea-433e-a790-9eb8c7b1b991");
        ComercioClienteDTO comercioClienteDTO = comercioClienteServ.leerPorID(uuid);
        if (comercioClienteDTO != null) {
            comercioClienteDTO.getId();
            comercioClienteDTO.getNombre();
            comercioClienteDTO.getUbicacion();
            Assertions.assertTrue(true);
        }
    }

}

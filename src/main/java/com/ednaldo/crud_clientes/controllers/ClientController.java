package com.ednaldo.crud_clientes.controllers;

import com.ednaldo.crud_clientes.dto.ClientDTO;
import com.ednaldo.crud_clientes.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insertClient(@RequestBody ClientDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.insertClient(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getClients(Pageable pageable) {
        return ResponseEntity.ok(clientService.getClients(pageable));
    }
}

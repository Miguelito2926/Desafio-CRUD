package com.ednaldo.crud_clientes.repositories;

import com.ednaldo.crud_clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientReposistory extends JpaRepository<Client, Long> {
}

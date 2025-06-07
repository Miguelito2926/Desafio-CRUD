package com.ednaldo.crud_clientes.services;

import com.ednaldo.crud_clientes.dto.ClientDTO;
import com.ednaldo.crud_clientes.entities.Client;
import com.ednaldo.crud_clientes.repositories.ClientReposistory;
import com.ednaldo.crud_clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientReposistory clientReposistory;

    public ClientService(ClientReposistory clientReposistory) {
        this.clientReposistory = clientReposistory;
    }

    public ClientDTO insertClient(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        clientReposistory.save(client);

        return new ClientDTO(client);
    }

    public Page<ClientDTO> getClients(Pageable pageable) {
        Page<Client> clients = clientReposistory.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    public ClientDTO getClient(Long id) {
       var client = clientReposistory.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("client with Id: "+ id +  " not found."));

       return new ClientDTO(client);
    }


    public ClientDTO updateClient(Long id, ClientDTO dto) {
        var client = clientReposistory.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("client with Id: "+ id +  " not found."));

        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
        clientReposistory.save(client);

       return new ClientDTO(client);
    }

    public void deleteClient(Long id) {
        if (!clientReposistory.existsById(id)) {
           throw new ResourceNotFoundException("client with Id: "+ id +  " not found.");
        }

        clientReposistory.deleteById(id);
    }
}

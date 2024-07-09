package com.example.demo.service;

import com.example.demo.Client;
import com.example.demo.ClientType;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(String fio, Date birthDate, String gender, ClientType clientType, String phone) {
        Client client = new Client(fio, birthDate, gender, clientType, phone);
        return clientRepository.save(client);
    }

    public List<Client> getClientsByFio(String fio) {
        return clientRepository.findByFio(fio);
    }

    public boolean checkIfClientExistsByFio(String fio) {
        List<Client> clients = clientRepository.findByFio(fio);
        return !clients.isEmpty();
    }

    public long countClientsByGender(String gender) {
        return clientRepository.countByGender(gender);
    }

}

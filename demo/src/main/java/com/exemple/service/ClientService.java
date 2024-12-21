package com.exemple.service;

import com.exemple.entity.Client;
import com.exemple.repository.IClientRepository;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clientRepository;

    public Client rechercherClientParTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }
}

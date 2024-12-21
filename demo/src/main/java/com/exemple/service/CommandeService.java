package com.exemple.service;

import com.exemple.entity.Commande;
import com.exemple.repository.ICommandeRepository;

@Service
public class CommandeService {

    @Autowired
    private ICommandeRepository commandeRepository;

    public void ajouterCommande(Commande commande) {
        commandeRepository.save(commande);
    }
}

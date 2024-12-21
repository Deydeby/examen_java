package com.exemple.repository;

import com.exemple.entity.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {

    void save(Commande commande);
}
